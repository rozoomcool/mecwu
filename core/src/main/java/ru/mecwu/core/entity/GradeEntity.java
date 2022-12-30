package ru.mecwu.core.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "grade", schema = "mecwudata")
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int grade;
    private Long userId;
    private Long cafeId;

    public GradeEntity(int grade) {
        this.grade = grade;
    }

    public GradeEntity() {
    }
    public Long geiId(){
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCafeId() {
        return cafeId;
    }

    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }
}
