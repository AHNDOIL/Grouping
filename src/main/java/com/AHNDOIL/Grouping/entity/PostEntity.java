package com.AHNDOIL.Grouping.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "POST_ENEITY")
public class PostEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    private String restaurant; //음식점 이름
    private String location; //배달 받을 위치
    private Long memberCount; // 멤버 수


    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity author;

    @OneToMany( //OneToMany에서는 mappedBy로 연관관계 설정
            targetEntity = CommentEntity.class,
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<CommentEntity> comments = new ArrayList<>();

    public PostEntity() {
    }

    public PostEntity(Long id, String title, String content, String restaurant, String location, Long memberCount, UserEntity author, List<CommentEntity> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.restaurant = restaurant;
        this.location = location;
        this.memberCount = memberCount;
        this.author = author;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Long getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Long memberCount) {
        this.memberCount = memberCount;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", restaurant='" + restaurant + '\'' +
                ", location='" + location + '\'' +
                ", memberCount=" + memberCount +
                ", author=" + author +
                ", comments=" + comments +
                '}';
    }
}
