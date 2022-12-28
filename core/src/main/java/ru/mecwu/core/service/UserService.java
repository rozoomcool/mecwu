package ru.mecwu.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mecwu.core.entity.UserEntity;
import ru.mecwu.core.exception.UserNotFoundException;
import ru.mecwu.core.repository.UserRepo;

public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Iterable<UserEntity> getAll(){
        return userRepo.findAll();
    }
    public UserEntity getOne(Long id) throws UserNotFoundException {
        UserEntity userEntity = userRepo.findById(id).get();
        if(userEntity == null){
            throw new UserNotFoundException("User not found");
        }
        return userEntity;
    }
}
