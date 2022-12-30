package ru.mecwu.core.model;

import ru.mecwu.core.entity.CafeEntity;

import java.util.Date;
import java.util.Set;

public class Cafe {
    private Long id;
    private String title;
    private String email, description, location;
    private long telephone;
    private int deliveryTime;
    private Role role;
    private Date createdAt;

    public Cafe() {
    }

    public Cafe(CafeEntity cafeEntity) {
        if(cafeEntity!=null){
            this.id = cafeEntity.getId();
            this.title = cafeEntity.getTitle();
            this.email = cafeEntity.getEmail();
            this.description = cafeEntity.getDescription();
            this.createdAt = cafeEntity.getCreatedAt();
            this.telephone = cafeEntity.getTelephone();
            this.createdAt = cafeEntity.getCreatedAt();
            this.deliveryTime = cafeEntity.getDeliveryTime();
            this.role = cafeEntity.getRole();
        }
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}