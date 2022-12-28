package ru.mecwu.core.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.mecwu.core.model.Role;
import ru.mecwu.core.model.Status;

import java.util.Date;

@Data
@Entity
@Table(name = "user", schema = "mecwudata")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private Long commentId;
    private Long gradeId;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Temporal(TemporalType.DATE)
    private Date createdAt;


}
