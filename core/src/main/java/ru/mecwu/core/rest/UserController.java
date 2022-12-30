package ru.mecwu.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mecwu.core.entity.CommentEntity;
import ru.mecwu.core.exception.UserNotFoundException;
import ru.mecwu.core.service.CommentService;
import ru.mecwu.core.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    public UserService userService;
    @Autowired
    private CommentService commentService;

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
    @GetMapping("/comment")
    public ResponseEntity getAllUserComments(@RequestParam String author ){
        try{
            return ResponseEntity.ok(commentService.getAllUserComments(author));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR!!!");
        }
    }
    @PostMapping("/comment/add")
    public ResponseEntity addComment(@RequestParam CommentEntity commentEntity, @RequestParam String author, @RequestParam Long cafeId){
        try{
            commentService.addComment(commentEntity, author, cafeId);
            return ResponseEntity.ok("Registration successful!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR!!!");
        }
    }
}
