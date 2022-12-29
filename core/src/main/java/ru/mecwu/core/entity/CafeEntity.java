package ru.mecwu.core.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cafe", schema = "mecwudata")
public class CafeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String email, password, description, location;
    private long telephone;
    private Set<FoodEntity> menu = new HashSet<FoodEntity>();
    private Set<GradeEntity> grade = new HashSet<GradeEntity>();
    private Set<OrderEntity> orders = new HashSet<OrderEntity>();
    private Set<CommentEntity> comments = new HashSet<CommentEntity>();
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public CafeEntity(String title, String email, String password, String description, long telephone, String location, Date createdAt) {
        this.title = title;
        this.email = email;
        this.password = password;
        this.description = description;
        this.location = location;
        this.telephone = telephone;
        this.createdAt = createdAt;
    }

    public CafeEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public Set<FoodEntity> getMenu() {
        return menu;
    }

    public void setMenu(Set<FoodEntity> menu) {
        this.menu = menu;
    }

    public Set<GradeEntity> getGrade() {
        return grade;
    }

    public void setGrade(Set<GradeEntity> grade) {
        this.grade = grade;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}