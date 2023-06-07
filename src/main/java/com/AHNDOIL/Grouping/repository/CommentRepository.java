package com.AHNDOIL.Grouping.repository;

import com.AHNDOIL.Grouping.entity.CommentEntity;
import com.AHNDOIL.Grouping.entity.PostEntity;
import com.AHNDOIL.Grouping.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
    List<CommentEntity> findByAuthor(UserEntity author);
    List<CommentEntity> findByPost(PostEntity postEntity);
}

