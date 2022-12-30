package ru.mecwu.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mecwu.core.entity.CommentEntity;
import ru.mecwu.core.entity.FoodEntity;
import ru.mecwu.core.entity.UserEntity;
import ru.mecwu.core.exception.CommentNotFoundException;
import ru.mecwu.core.repository.FoodRepo;

import java.util.Iterator;

public class FoodService {
    @Autowired
    private FoodRepo foodRepo;

    public FoodEntity getOne(Long id) throws CommentNotFoundException {
        FoodEntity foodEntity = this.foodRepo.findById(id).get();
        if(foodEntity== null){
            throw new CommentNotFoundException("Comment not found");
        }
        return foodEntity;
    }
    public void addFood(FoodEntity foodEntity, Long cafeId) {
        foodEntity.setCafeId(cafeId);
        foodRepo.save(foodEntity);
    }
    public Iterator<FoodEntity> getAllCafeMenu(Long cafeId){
        return (Iterator<FoodEntity>) foodRepo.findAllByCafeId(cafeId);
    }
}
