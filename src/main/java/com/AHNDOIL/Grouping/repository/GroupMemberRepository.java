package com.AHNDOIL.Grouping.repository;

import com.AHNDOIL.Grouping.entity.GroupMemberEntity;
import com.AHNDOIL.Grouping.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupMemberRepository extends CrudRepository<GroupMemberEntity, Long> {

}
