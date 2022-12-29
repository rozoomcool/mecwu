package ru.mecwu.core.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mecwu.core.entity.UserEntity;
import ru.mecwu.core.model.AuthenticateRequestDTO;
import ru.mecwu.core.repository.UserRepo;
import ru.mecwu.core.security.JwtTokenProvider;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private UserRepo userRepo;
    private JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationManager authenticationManager, UserRepo userRepository, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("login")
    public ResponseEntity authenticate(@RequestBody AuthenticateRequestDTO request){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmailOrNickName(), request.getPassword()));
            UserEntity userEntity = userRepo.findByEmail(request.getEmailOrNickName()).orElse(
                    userRepo.findByNickname(request.getEmailOrNickName()).orElseThrow(
                            () -> new UsernameNotFoundException("UserNotFound")
                    )
            );
            String token = jwtTokenProvider.createToken(request.getEmailOrNickName(), userEntity.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", request.getEmailOrNickName());
            response.put("token", token);

            return ResponseEntity.ok(response);
        }catch(AuthenticationException e){
            return new ResponseEntity<>("Invalid nickname/password combination", HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("logout")
    public void authenticate(HttpServletRequest request, HttpServletResponse response){
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
