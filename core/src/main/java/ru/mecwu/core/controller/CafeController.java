package ru.mecwu.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mecwu.core.entity.UserEntity;
import ru.mecwu.core.exception.UserAlreadyExistException;
import ru.mecwu.core.exception.UserNotFoundException;
import ru.mecwu.core.service.UserService;

@RestController
@RequestMapping("mecwu/v1/cafe")
public class CafeController {
    @Autowired
    public UserService userService;
    @GetMapping
    public ResponseEntity getUsers(){
        try{
            return ResponseEntity.ok(userService.getAll());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        try{
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR!!!");
        }
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestParam UserEntity userEntity){
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
