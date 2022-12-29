package ru.mecwu.core.entity;

import jakarta.persistence.*;

import java.util.Date;
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
    private Set<Long> menu;
    private Set<Long> grade;
    private Set<Long> foods;
    private Set<Long> orders;
    private Set<Long> comments;
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public CafeEntity(String title, String email, String password, String description, String location, Date createdAt) {
        this.title = title;
        this.email = email;
        this.password = password;
        this.description = description;
        this.location = location;
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

    public Set<Long> getMenu() {
        return menu;
    }

    public void setMenu(Set<Long> menu) {
        this.menu = menu;
    }

    public Set<Long> getGrade() {
        return grade;
    }

    public void setGrade(Set<Long> grade) {
        this.grade = grade;
    }

    public Set<Long> getFoods() {
        return foods;
    }

    public void setFoods(Set<Long> foods) {
        this.foods = foods;
    }

    public Set<Long> getOrders() {
        return orders;
    }

    public void setOrders(Set<Long> orders) {
        this.orders = orders;
    }

    public Set<Long> getComments() {
        return comments;
    }

    public void setComments(Set<Long> comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}