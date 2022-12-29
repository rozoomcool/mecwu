package ru.mecwu.core.model;

import ru.mecwu.core.entity.CommentEntity;
import ru.mecwu.core.entity.GradeEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class User {
    private Long id;
    private String nickname;
    private String email;
    private Set<CommentEntity> comments = new HashSet<CommentEntity>();
    private Set<GradeEntity> grades = new HashSet<GradeEntity>();
    private Role role;
    private Status status;
    private Date createdAt;

    public User(Long id, String nickname, String email, Set<CommentEntity> comments, Set<GradeEntity> grades, Role role, Status status, Date createdAt) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.comments = comments;
        this.grades = grades;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    public Set<GradeEntity> getGrades() {
        return grades;
    }

    public void setGrades(Set<GradeEntity> grades) {
        this.grades = grades;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}