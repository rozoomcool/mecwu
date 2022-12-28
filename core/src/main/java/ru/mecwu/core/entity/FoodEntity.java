package ru.mecwu.core.entity;

<<<<<<< HEAD
import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
>>>>>>> deni
import lombok.Data;

@Data
@Entity
@Table(name = "food", schema = "mecwudata")
public class FoodEntity {
<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String description;
=======

>>>>>>> deni

}
