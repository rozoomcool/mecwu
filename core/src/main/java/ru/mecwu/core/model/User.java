package ru.mecwu.core.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class User {
    private Long id;
    private String nickname;
    private String email;
    private Set<Long> comments;
    private Set<Long> grades;
    private Role role;
    private Status status;
    private Date createdAt;

}
