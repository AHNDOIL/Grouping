package com.AHNDOIL.Grouping.service;

import com.AHNDOIL.Grouping.dto.GroupDto;
import com.AHNDOIL.Grouping.entity.GroupEntity;
import com.AHNDOIL.Grouping.entity.UserEntity;

import java.util.Collection;

public interface GroupService {

    GroupEntity create(String groupName, String restaurant, String location, int memberCount, UserEntity leader);
    //GroupDto read(UserEntity userEntity);
    Collection<GroupDto> readAll(UserEntity userEntity);
    boolean update(Long groupId, GroupDto groupDto);
    boolean delete(Long groupId);
}
