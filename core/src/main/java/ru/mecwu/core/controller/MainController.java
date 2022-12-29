package ru.mecwu.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("mecwu/v1/main")
public class MainController {
    @GetMapping
    public String getMain(){
        return "Hallo mazafaka";
    }
}
