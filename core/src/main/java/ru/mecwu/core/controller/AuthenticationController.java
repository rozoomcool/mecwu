package ru.mecwu.core.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mecwu.core.model.AuthenticateRequestDTO;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {
    @PostMapping("login")
    public ResponseEntity authenticate(@RequestBody AuthenticateRequestDTO request){
        try{

        }catch(Exception e){

        }
        return null;
    }
    @PostMapping("logout")
    public void authenticate(HttpServletRequest request, HttpServletResponse response){
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
