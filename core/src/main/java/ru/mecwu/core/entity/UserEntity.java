package ru.mecwu.core.entity;

import jakarta.persistence.*;
import ru.mecwu.core.model.Role;
import ru.mecwu.core.model.Status;

import java.util.*;

@Entity
@Table(name = "user", schema = "mecwudata")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private int points;
    @Enumerated(EnumType.STRING)
    private Role role;
//    private List<GrantedAuthority> authorities;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public UserEntity(String nickname, String email, String password, Role role) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.role = Role.USER;
//        this.authorities.add(Role.USER);
        this.status = Status.ACTIVE;
        this.createdAt = new Date();
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

//    public List<GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(List<GrantedAuthority> authorities) {
//        this.authorities = authorities;
//    }

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
