package ru.mecwu.core.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.mecwu.core.model.Role;
import ru.mecwu.core.model.Status;

import java.util.Date;
import java.util.Set;

@Data
@GradeEntity
@Table(name = "user", schema = "mecwudata")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private Set<Long> comments;
    private Set<Long> grades;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Temporal(TemporalType.DATE)
    private Date createdAt;


}
