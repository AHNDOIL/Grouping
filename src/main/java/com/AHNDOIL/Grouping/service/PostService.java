package com.AHNDOIL.Grouping.service;

import com.AHNDOIL.Grouping.dto.PostDto;

import java.util.Collection;


public interface PostService {

    PostDto create(PostDto postDto);
    PostDto read(Long postId);
    Collection<PostDto> readAll();
    boolean update(Long postId, PostDto postDto);
    boolean delete(Long postId);
}
