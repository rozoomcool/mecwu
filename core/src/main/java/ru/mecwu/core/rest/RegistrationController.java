package ru.mecwu.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mecwu.core.entity.UserEntity;
import ru.mecwu.core.exception.UserAlreadyExistException;
import ru.mecwu.core.service.UserService;

@RestController
@RequestMapping("registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity userEntity) {
        try{
            userService.registration(userEntity);
            return ResponseEntity.ok("Registration successful!");
        }catch(UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR!!!");
        }
    }
}