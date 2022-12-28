package ru.mecwu.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mecwu.core.entity.UserEntity;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public ResponseEntity getUsers(){
        try{
            return ResponseEntity.ok("");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("");
        }
    }
}
