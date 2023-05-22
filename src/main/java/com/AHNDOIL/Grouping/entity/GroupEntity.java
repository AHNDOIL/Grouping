package com.AHNDOIL.Grouping.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GROUP_ENTITY")
public class GroupEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    private String restaurant;
    private String location;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leader_id")
    private UserEntity leader;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroupMemberEntity> members = new ArrayList<>();


    public GroupEntity() {
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

    public List<GroupMemberEntity> getMembers() {
        return members;
    }

    public void setMembers(List<GroupMemberEntity> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "GroupEntity{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", restaurant='" + restaurant + '\'' +
                ", location='" + location + '\'' +
                ", leader=" + leader +
                ", members=" + members +
                '}';
    }
}
