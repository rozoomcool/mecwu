package ru.mecwu.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mecwu.core.entity.CafeEntity;
import ru.mecwu.core.entity.CommentEntity;
import ru.mecwu.core.entity.UserEntity;
import ru.mecwu.core.exception.CommentNotFoundException;
import ru.mecwu.core.exception.UserAlreadyExistException;
import ru.mecwu.core.exception.UserNotFoundException;
import ru.mecwu.core.model.Cafe;
import ru.mecwu.core.model.User;
import ru.mecwu.core.repository.CafeRepo;
import ru.mecwu.core.repository.CommentRepo;
import ru.mecwu.core.repository.UserRepo;

@Service
public class CafeService {
    @Autowired
    private CafeRepo cafeRepo;

    public Iterable<CafeEntity> getAll(){
        return cafeRepo.findAll();
    }
    public Cafe getOne(Long id) throws UserNotFoundException {
        CafeEntity cafeEntity = cafeRepo.findById(id).get();
        if(cafeEntity == null){
            throw new UserNotFoundException("User not found");
        }
        return new Cafe(cafeEntity);
    }
    public void registration(CafeEntity cafeEntity) throws UserAlreadyExistException {
        if(cafeRepo.findByTitle(cafeEntity.getTitle()) != null){
            throw new UserAlreadyExistException("User already exist!");
        }
        cafeRepo.save(cafeEntity);
    }
}
