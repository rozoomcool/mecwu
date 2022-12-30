package ru.mecwu.core.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mecwu.core.entity.FoodEntity;

import java.util.Iterator;
import java.util.Optional;

public interface FoodRepo extends CrudRepository<FoodEntity, Long> {
    Iterator<FoodEntity> findAllByCafeId(Long cafeId);
}
