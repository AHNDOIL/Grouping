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




}
