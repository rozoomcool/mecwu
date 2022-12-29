package ru.mecwu.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mecwu.core.entity.UserEntity;
import ru.mecwu.core.exception.UserNotFoundException;
import ru.mecwu.core.exception.UserAlreadyExistException;
import ru.mecwu.core.model.User;
import ru.mecwu.core.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Iterable<UserEntity> getAll(){
        return userRepo.findAll();
    }
    public User getOne(Long id) throws UserNotFoundException {
        UserEntity userEntity = userRepo.findById(id).get();
        if(userEntity == null){
            throw new UserNotFoundException("User not found");
        }
        return new User(userEntity);
    }
    public void registration(UserEntity userEntity) throws UserAlreadyExistException {
        if(userRepo.findByNickname(userEntity.getNickname()) != null){
            throw new UserAlreadyExistException("User already exist!");
        }
        userRepo.save(userEntity);
    }
}
