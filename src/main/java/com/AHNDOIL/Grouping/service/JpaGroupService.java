package com.AHNDOIL.Grouping.service;

import com.AHNDOIL.Grouping.dto.GroupDto;
import com.AHNDOIL.Grouping.dto.GroupMemberDto;
import com.AHNDOIL.Grouping.entity.GroupEntity;
import com.AHNDOIL.Grouping.entity.GroupMemberEntity;
import com.AHNDOIL.Grouping.entity.UserEntity;
import com.AHNDOIL.Grouping.infra.AuthenticationFacade;
import com.AHNDOIL.Grouping.repository.GroupMemberRepository;
import com.AHNDOIL.Grouping.repository.GroupRepository;
import com.AHNDOIL.Grouping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JpaGroupService implements GroupService{

    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;

    public JpaGroupService(
            @Autowired GroupRepository groupRepository,
            @Autowired GroupMemberRepository groupMemberRepository
    ) {
        this.groupRepository = groupRepository;
        this.groupMemberRepository = groupMemberRepository;
    }

    @Override
    @Transactional
    public GroupEntity create(String groupName, String restaurant, String location, int memberCount, UserEntity leader) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setGroupName(groupName);
        groupEntity.setRestaurant(restaurant);
        groupEntity.setLocation(location);
        groupEntity.setMemberCount(memberCount);
        groupEntity.setLeader(leader);

        GroupEntity savedGroup = this.groupRepository.save(groupEntity);

        GroupMemberEntity groupMemberEntity = new GroupMemberEntity();
        groupMemberEntity.setGroup(savedGroup);
        groupMemberEntity.setUser(leader);
        this.groupMemberRepository.save(groupMemberEntity);

        return savedGroup;
    }

    @Override
    public Collection<GroupDto> readAll(UserEntity userEntity) {

        List<GroupMemberEntity> groupMemberships = userEntity.getGroupMemberships();
        List<GroupDto> groupDtos = new ArrayList<>();

        for (GroupMemberEntity groupMemberEntity : groupMemberships) {
            GroupEntity groupEntity = groupMemberEntity.getGroup();
            List<GroupMemberDto> groupMemberDtos = groupEntity.getMembers().stream()
                    .map(member -> new GroupMemberDto(
                            member.getId(),
                            member.getGroup(),
                            member.getUser()
                    ))
                    .collect(Collectors.toList());

            GroupDto groupDto = new GroupDto(
                    groupEntity.getId(),
                    groupEntity.getGroupName(),
                    groupEntity.getRestaurant(),
                    groupEntity.getLocation(),
                    groupEntity.getMemberCount(),
                    groupEntity.getLeader(),
                    groupMemberDtos
            );
            groupDtos.add(groupDto);
        }
        return groupDtos;
    }

    @Override
    public boolean update(Long groupId, GroupDto groupDto) {
        return false;
    }

    @Override
    public boolean delete(Long groupId) {
        return false;
    }
}
