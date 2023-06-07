package com.AHNDOIL.Grouping.service;

import com.AHNDOIL.Grouping.dto.CommentDto;
import com.AHNDOIL.Grouping.dto.PostDto;
import com.AHNDOIL.Grouping.entity.PostEntity;
import com.AHNDOIL.Grouping.entity.UserEntity;

import java.util.Collection;
import java.util.List;

public interface CommentService {

    CommentDto create(CommentDto commentDto, Long postId);
    CommentDto read(Long commentId);
    Collection<CommentDto> readByUser(UserEntity userEntity);
    Collection<CommentDto> readByPost(PostEntity postEntity);
    boolean update(Long commentId, CommentDto commentDto);
    boolean delete(Long commentId);
}
