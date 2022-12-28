package ru.mecwu.core.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "grade", schema = "mecwudata")
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int grade;

    public GradeEntity(int grade) {
        this.grade = grade;
    }

    public GradeEntity() {
    }
}
