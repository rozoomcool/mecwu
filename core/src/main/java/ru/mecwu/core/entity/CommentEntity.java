package ru.mecwu.core.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "comment", schema = "mecwudata")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinColumn(name = "author_id", nullable = false)
    private String author;
    private String comment;
    private Long gradeId;
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public CommentEntity(String userName, String comment, Long gradeId, Date createdAt) {
        this.author = userName;
        this.comment = comment;
        this.gradeId = gradeId;
        this.createdAt = createdAt;
    }

    public CommentEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
