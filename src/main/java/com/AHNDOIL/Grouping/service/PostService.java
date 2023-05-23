package com.AHNDOIL.Grouping.service;

import com.AHNDOIL.Grouping.dto.PostDto;


public interface PostService {

    PostDto create(PostDto postDto);
    PostDto read(Long postId);
    //Collection<PostDto> readAll() 음식별로 보기?
    boolean update(Long postId, PostDto postDto);
    boolean delete(Long postId);
}
