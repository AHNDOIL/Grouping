package com.AHNDOIL.Grouping.dto;

import com.AHNDOIL.Grouping.entity.GroupEntity;
import com.AHNDOIL.Grouping.entity.UserEntity;

public class GroupMemberDto {

    private Long id;
    private GroupEntity group;
    private UserEntity user;

    public GroupMemberDto() {
    }

    public GroupMemberDto(Long id, GroupEntity group, UserEntity user) {
        this.id = id;
        this.group = group;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "GroupMemberDto{" +
                "id=" + id +
                ", group=" + group +
                ", user=" + user +
                '}';
    }
}
