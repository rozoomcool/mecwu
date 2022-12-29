package ru.mecwu.core.entity;

import jakarta.persistence.*;
import ru.mecwu.core.model.Role;
import ru.mecwu.core.model.Status;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "mecwudata")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private Set<CommentEntity> comments = new HashSet<CommentEntity>();
    private Set<GradeEntity> grades = new HashSet<GradeEntity>();
    private int points;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public UserEntity(String nickname, String email, String password, Set<CommentEntity> comments, Set<GradeEntity> grades, Role role, Status status, Date createdAt) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.comments = comments;
        this.grades = grades;
        this.role = role;
        this.status = status;
        this.createdAt = createdAt;
        this.points = 0;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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
