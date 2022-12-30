package ru.mecwu.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mecwu.core.entity.CafeEntity;
import ru.mecwu.core.entity.FoodEntity;
import ru.mecwu.core.exception.UserAlreadyExistException;
import ru.mecwu.core.exception.UserNotFoundException;
import ru.mecwu.core.service.CafeService;
import ru.mecwu.core.service.FoodService;

@RestController
@RequestMapping("/cafe")
public class CafeController {
    @Autowired
    private CafeService cafeService;
    @Autowired
    private FoodService foodService;
    @GetMapping
    public String getCafe(){
        return "Cafe";
    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        try{
            return ResponseEntity.ok(cafeService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR!!!");
        }
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody CafeEntity cafeEntity){
        try{
            cafeService.registration(cafeEntity);
            return ResponseEntity.ok("Registration successful!");
        }catch(UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR!!!");
        }
    }
    @PostMapping("menu/add")
    public ResponseEntity addFoodToMenu(@RequestBody FoodEntity foodEntity, Long cafeId){
        try{
            return ResponseEntity.ok(foodService.getAllCafeMenu(cafeId));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
