package ru.mecwu.core.model;

import java.util.Date;
import java.util.Set;

public class Cafe {
    private Long id;
    private String title;
    private String email, password, description;
    private long telephone;
    private Set<Long> menu;
    private Set<Long> grade;
    private Set<Long> foods;
    private Set<Long> orders;
    private Set<Long> comments;
    private Date createdAt;

    public Cafe() {
    }

    public Cafe(Long id, String title, String email, String password, String description, Set<Long> menu, Set<Long> grade, Set<Long> foods, Set<Long> orders, Set<Long> comments, Date createdAt) {
        this.id = id;
        this.title = title;
        this.email = email;
        this.password = password;
        this.description = description;
        this.menu = menu;
        this.grade = grade;
        this.foods = foods;
        this.orders = orders;
        this.comments = comments;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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