package ru.mecwu.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mecwu.core.entity.UserEntity;
import ru.mecwu.core.exception.UserAlreadyExistException;
import ru.mecwu.core.service.UserService;

@Controller
@RequestMapping("/mecwu/v1")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
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