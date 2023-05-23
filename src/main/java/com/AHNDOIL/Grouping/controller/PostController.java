package com.AHNDOIL.Grouping.controller;

import com.AHNDOIL.Grouping.dto.PostDto;
import com.AHNDOIL.Grouping.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    public PostController(@Autowired PostService postService){
        this.postService = postService;
    }

    @GetMapping("create")
    public String createPostForm(Model model){
        PostDto postDto = new PostDto();
        postDto.setMemberCount(1L);
        model.addAttribute("postDto",postDto); //기본 세팅을 전송

        return "create-post";
    }

    @PostMapping("create")
    public String createPost(@ModelAttribute("postDto") PostDto postDto){ //html에서 받아온 변수가 자동으로 postDto에 할당됨
        this.postService.create(postDto);
        return "redirect:/home";
    }


    @GetMapping("read/{postId}") //특정 post만 읽기
    public String readPost(@PathVariable("postId") Long postId, Model model){

        PostDto postDto = this.postService.read(postId);
        if(postDto == null){
            return "error"; //error 페이지로 이동
        }
        model.addAttribute("postDto", postDto);
        return "read-post";
    }

    @GetMapping("update/{postId}")
    public String updatePostForm(@PathVariable("postId") Long postId, Model model){

        PostDto postDto = postService.read(postId);
        model.addAttribute("postDto", postDto);

        return "update-post";
    }

    @PostMapping("update/{postId}") //html 때문에 post로 해야함
    public String updatePost(@PathVariable("postId") Long postId,
                             @ModelAttribute("postDto") PostDto postDto){
        this.postService.update(postId, postDto);
        return "redirect:/home";
    }


    @DeleteMapping("delete/{postId}")
    public String deletePost(@PathVariable("postId") Long postId){
        this.postService.delete(postId);
        return "redirect:/home";
    }

}
