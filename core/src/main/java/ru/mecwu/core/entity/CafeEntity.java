package ru.mecwu.core.entity;

import jakarta.persistence.*;
import ru.mecwu.core.model.Role;

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
    private int deliveryTime;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Set<Long> menu = new HashSet<Long>();
    private Set<Long> grade = new HashSet<Long>();
    private Set<Long> orders = new HashSet<Long>();
    private Set<Long> comments = new HashSet<Long>();
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public CafeEntity(String title, String email, String password, String description, long telephone, String location) {
        this.title = title;
        this.email = email;
        this.password = password;
        this.description = description;
        this.location = location;
        this.telephone = telephone;
        this.createdAt = new Date();
        this.deliveryTime = 45;
        this.role = Role.Cafe;
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

    public int getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public Set<Long> getOrders() {
        return orders;
    }

    public void setOrders(Set<Long> orders) {
        this.orders = orders;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}