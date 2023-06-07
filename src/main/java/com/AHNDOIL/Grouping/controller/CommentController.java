package com.AHNDOIL.Grouping.controller;

import com.AHNDOIL.Grouping.dto.CommentDto;
import com.AHNDOIL.Grouping.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("comment")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    public CommentController(@Autowired CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("create")
    public String createComment(
            @ModelAttribute("commentDto") CommentDto commentDto,
            @RequestParam("postId") Long postId){

        this.commentService.create(commentDto, postId);

        return "redirect:/post/read/" + postId; //해당 댓글이 작성된 post로 리다이렉트
    }
}
