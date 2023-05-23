package com.AHNDOIL.Grouping.dto;

import com.AHNDOIL.Grouping.entity.UserEntity;

import java.util.List;

public class GroupDto {


    private Long id;
    private String groupName;
    private String restaurant;
    private String location;
    private UserEntity leader;
    private List<GroupMemberDto> members;
    // 필요한 추가 필드들...

    public GroupDto() {
    }

    public GroupDto(Long id, String groupName, String restaurant, String location, UserEntity leader, List<GroupMemberDto> members) {
        this.id = id;
        this.groupName = groupName;
        this.restaurant = restaurant;
        this.location = location;
        this.leader = leader;
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserEntity getLeader() {
        return leader;
    }

    public void setLeader(UserEntity leader) {
        this.leader = leader;
    }

    public List<GroupMemberDto> getMembers() {
        return members;
    }

    public void setMembers(List<GroupMemberDto> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "GroupDto{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", restaurant='" + restaurant + '\'' +
                ", location='" + location + '\'' +
                ", leader=" + leader +
                ", members=" + members +
                '}';
    }
}
