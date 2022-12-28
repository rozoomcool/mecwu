package ru.mecwu.core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String comment;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
}
