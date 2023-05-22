package com.AHNDOIL.Grouping.repository;

import com.AHNDOIL.Grouping.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
