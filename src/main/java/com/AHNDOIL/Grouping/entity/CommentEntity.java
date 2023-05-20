package com.AHNDOIL.Grouping.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "COMMENT_ENTITY")
public class CommentEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity author;


    @ManyToOne(
            targetEntity = PostEntity.class,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity post;

    public CommentEntity() {
    }

    public CommentEntity(Long id, String content, UserEntity author, PostEntity post) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author=" + author +
                ", post=" + post +
                '}';
    }
}
