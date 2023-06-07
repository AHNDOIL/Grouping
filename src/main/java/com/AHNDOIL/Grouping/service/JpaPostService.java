package com.AHNDOIL.Grouping.service;

import com.AHNDOIL.Grouping.dto.PostDto;
import com.AHNDOIL.Grouping.entity.GroupEntity;
import com.AHNDOIL.Grouping.entity.GroupMemberEntity;
import com.AHNDOIL.Grouping.entity.PostEntity;
import com.AHNDOIL.Grouping.entity.UserEntity;
import com.AHNDOIL.Grouping.infra.AuthenticationFacade;
import com.AHNDOIL.Grouping.repository.GroupRepository;
import com.AHNDOIL.Grouping.repository.PostRepository;
import com.AHNDOIL.Grouping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class JpaPostService implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthenticationFacade authenticationFacade;
    private final GroupService groupService;

    public JpaPostService(
            @Autowired PostRepository postRepository,
            @Autowired UserRepository userRepository,
            @Autowired AuthenticationFacade authenticationFacade,
            @Autowired GroupService groupService
    ){
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.authenticationFacade = authenticationFacade;
        this.groupService = groupService;
    }

    @Override
    public PostDto create(PostDto postDto) {

        //현재 사용자 정보 가져오기
        String username = authenticationFacade.getUserName();
        UserEntity user = userRepository.findByUsername(username);

        //예외 처리 하기

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(postDto.getTitle());
        postEntity.setAuthor(user);
        postEntity.setContent(postDto.getContent());
        postEntity.setRestaurant(postDto.getRestaurant());
        postEntity.setLocation(postDto.getLocation());
        postEntity.setMemberCount(postDto.getMemberCount());
        postEntity = this.postRepository.save(postEntity);

        GroupEntity groupEntity = groupService.create(postDto.getTitle(), postDto.getRestaurant(),
                                                    postDto.getLocation(), postDto.getMemberCount(), user);


        return new PostDto(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getRestaurant(),
                postEntity.getLocation(),
                postEntity.getMemberCount(),
                postEntity.getAuthor()
        );


    }

    @Override
    public PostDto read(Long postId) {
        if(!this.postRepository.existsById(postId)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        PostEntity postEntity = this.postRepository.findById(postId).get();

        return new PostDto(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getRestaurant(),
                postEntity.getLocation(),
                postEntity.getMemberCount(),
                postEntity.getAuthor()
        );
    }

    @Override
    public Collection<PostDto> readAll(){
        Iterable<PostEntity> postEntities = this.postRepository.findAll();
        Collection<PostDto> postDtos = new ArrayList<>();

        for (PostEntity postEntity : postEntities) {
            PostDto postDto = new PostDto(
                    postEntity.getId(),
                    postEntity.getTitle(),
                    postEntity.getContent(),
                    postEntity.getRestaurant(),
                    postEntity.getLocation(),
                    postEntity.getMemberCount(),
                    postEntity.getAuthor()
            );
            postDtos.add(postDto);
        }

        return postDtos;
    }

    @Override
    public boolean update(Long postId, PostDto postDto) { //다른 유저가 버튼을 누르자 마자 forbidden을 시키도록 수정해야함
        if(!this.postRepository.existsById(postId)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        PostEntity postEntity = this.postRepository.findById(postId).get();

        String username = authenticationFacade.getUserName();
        UserEntity user = userRepository.findByUsername(username);

        if(!user.equals(postEntity.getAuthor())) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        postEntity.setTitle(
                postDto.getTitle() == null ? postEntity.getTitle() : postDto.getTitle());
        postEntity.setContent(
                postDto.getContent() == null ? postEntity.getContent() : postDto.getContent());
        postEntity.setRestaurant(
                postDto.getRestaurant() == null ? postEntity.getRestaurant() : postDto.getRestaurant());
        postEntity.setLocation(
                postDto.getLocation() == null ? postEntity.getLocation() : postDto.getLocation());
        postEntity.setMemberCount(postDto.getMemberCount());
        this.postRepository.save(postEntity);
        return true;
    }

    @Override
    public boolean delete(Long postId) {
        if (!this.postRepository.existsById(postId)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        PostEntity postEntity = this.postRepository.findById(postId).get();

        String username = authenticationFacade.getUserName();
        UserEntity user = userRepository.findByUsername(username);

        if(!user.equals(postEntity.getAuthor())) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        this.postRepository.deleteById(postId);
        return true;
    }
}
