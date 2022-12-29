package ru.mecwu.core.entity;

import jakarta.persistence.*;
import ru.mecwu.core.model.Status;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "order", schema = "mecwudata")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<FoodEntity> body = new LinkedList<FoodEntity>();
    private double totalPrice;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public OrderEntity() {
    }

    public OrderEntity(LinkedList<FoodEntity> body, Date createdAt) {
        this.body = body;
        this.createdAt = createdAt;
        this.totalPrice = calculatePrice();
    }

    private int calculatePrice(){
        double count = 0;
        for(Iterator<FoodEntity> i = body.listIterator(); i.hasNext();){
            FoodEntity temp = i.next();
            count += temp.getPrice();
        }
        return (int) count;
    }

    public Long getId() {
        return id;
    }

    public List<FoodEntity> getBody() {
        return body;
    }

    public void setBody(LinkedList<FoodEntity> body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
