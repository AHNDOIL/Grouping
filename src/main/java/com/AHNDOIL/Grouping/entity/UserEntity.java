package com.AHNDOIL.Grouping.entity;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "USER_ENTITY")
@EntityListeners(AuditingEntityListener.class) //BaseEntity
public class UserEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String nickname;

    private String role;


    @OneToMany(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "author", //postEntity의 author
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostEntity> posts = new ArrayList<>();

    @OneToMany(
            targetEntity = CommentEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "author", //commentEntity의 author
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<CommentEntity> comments = new ArrayList<>();

    @OneToMany(
            targetEntity = GroupEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "leader",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<GroupEntity> groups = new ArrayList<>();


    @OneToMany( //OneToMany에서는 targetEntity를 지정하지 않아도 자동으로 추론해준다.
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<GroupMemberEntity> groupMemberships = new ArrayList<>();



    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public List<GroupMemberEntity> getGroupMemberships() {
        return groupMemberships;
    }

    public void setGroupMemberships(List<GroupMemberEntity> groupMemberships) {
        this.groupMemberships = groupMemberships;
    }

    public List<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupEntity> groups) {
        this.groups = groups;
    }
    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", role='" + role + '\'' +
                ", posts=" + posts +
                ", comments=" + comments +
                ", groups=" + groups +
                ", groupMemberships=" + groupMemberships +
                '}';
    }



}
