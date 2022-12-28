package ru.mecwu.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "food", schema = "mecwudata")
public class Food {


}
