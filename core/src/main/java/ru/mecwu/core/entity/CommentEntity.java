package ru.mecwu.core.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "comment", schema = "mecwudata")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String comment;
    private Long gradeId;
    @Temporal(TemporalType.DATE)
    private Date createdAt;
}
