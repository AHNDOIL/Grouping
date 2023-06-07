package com.AHNDOIL.Grouping.service;

import com.AHNDOIL.Grouping.dto.CommentDto;
import com.AHNDOIL.Grouping.entity.CommentEntity;
import com.AHNDOIL.Grouping.entity.PostEntity;
import com.AHNDOIL.Grouping.entity.UserEntity;
import com.AHNDOIL.Grouping.infra.AuthenticationFacade;
import com.AHNDOIL.Grouping.repository.CommentRepository;
import com.AHNDOIL.Grouping.repository.PostRepository;
import com.AHNDOIL.Grouping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class JpaCommentService implements CommentService{

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final AuthenticationFacade authenticationFacade;

    public JpaCommentService(
            @Autowired CommentRepository commentRepository,
            @Autowired UserRepository userRepository,
            @Autowired PostRepository postRepository,
            @Autowired AuthenticationFacade authenticationFacade
    ) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public CommentDto create(CommentDto commentDto, Long postId) {

        //현재 사용자 정보 가져오기
        String username = authenticationFacade.getUserName();
        UserEntity user = userRepository.findByUsername(username);

        PostEntity postEntity = this.postRepository.findById(postId).get();

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setContent(commentDto.getContent());
        commentEntity.setAuthor(user);
        commentEntity.setPost(postEntity);
        commentEntity = this.commentRepository.save(commentEntity);


        return new CommentDto(
                commentEntity.getId(),
                commentEntity.getContent(),
                commentEntity.getAuthor(),
                commentEntity.getPost()
        );
    }

    @Override
    public CommentDto read(Long commentId) {
        if(!this.commentRepository.existsById(commentId)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        CommentEntity commentEntity = this.commentRepository.findById(commentId).get();

        return new CommentDto(
                commentEntity.getId(),
                commentEntity.getContent(),
                commentEntity.getAuthor(),
                commentEntity.getPost()
        );
    }

    @Override
    public Collection<CommentDto> readByPost(PostEntity postEntity) {
        Iterable<CommentEntity> commentEntities = this.commentRepository.findByPost(postEntity);
        Collection<CommentDto> commentDtos = new ArrayList<>();

        for(CommentEntity commentEntity : commentEntities){
            CommentDto commentDto = new CommentDto(
                    commentEntity.getId(),
                    commentEntity.getContent(),
                    commentEntity.getAuthor(),
                    commentEntity.getPost()
            );
            commentDtos.add(commentDto);
        }
        return commentDtos;
    }

    @Override
    public Collection<CommentDto> readByUser(UserEntity userEntity){
        Iterable<CommentEntity> commentEntities = this.commentRepository.findByAuthor(userEntity);
        Collection<CommentDto> commentDtos = new ArrayList<>();

        for(CommentEntity commentEntity : commentEntities){
            CommentDto commentDto = new CommentDto(
                    commentEntity.getId(),
                    commentEntity.getContent(),
                    commentEntity.getAuthor(),
                    commentEntity.getPost()
            );
            commentDtos.add(commentDto);
        }
        return commentDtos;
    }

    @Override
    public boolean update(Long commentId, CommentDto commentDto) {
        if(!this.commentRepository.existsById(commentId)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        CommentEntity commentEntity = this.commentRepository.findById(commentId).get();

        String username = authenticationFacade.getUserName();
        UserEntity user = userRepository.findByUsername(username);

        if(!user.equals(commentEntity.getAuthor())) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        commentEntity.setContent(
                commentDto.getContent() == null ? commentEntity.getContent() : commentDto.getContent()
        );

        this.commentRepository.save(commentEntity);
        return true;
    }

    @Override
    public boolean delete(Long commentId) {
        if(!this.commentRepository.existsById(commentId)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        CommentEntity commentEntity = this.commentRepository.findById(commentId).get();

        String username = authenticationFacade.getUserName();
        UserEntity user = userRepository.findByUsername(username);

        if(!user.equals(commentEntity.getAuthor())) throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        this.commentRepository.deleteById(commentId);
        return true;
    }
}
