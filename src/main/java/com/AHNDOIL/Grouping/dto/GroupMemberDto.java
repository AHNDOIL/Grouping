package com.AHNDOIL.Grouping.dto;

public class GroupMemberDto {

    private Long id;
    private GroupDto group;
    private UserDto user;

    public GroupMemberDto() {
    }

    public GroupMemberDto(Long id, GroupDto group, UserDto user) {
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

    public GroupDto getGroup() {
        return group;
    }

    public void setGroup(GroupDto group) {
        this.group = group;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
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
