package ru.mecwu.core.security;

import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import ru.mecwu.core.entity.GradeEntity;
import ru.mecwu.core.entity.UserEntity;
import ru.mecwu.core.exception.JwtAuthenticationException;
import ru.mecwu.core.model.Role;
import ru.mecwu.core.repository.UserRepo;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {
    private final UserRepo userRepo;
    @Value("${jwt.secret}")
    private String secretKey;
    @Value("${jwt.header}")
    private String authorizationHeader;
    @Value("${jwt.expiration}")
    private long validityInMilliseconds;
    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public JwtTokenProvider(@Qualifier() UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public String createToken(String username, String role){
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("role", role);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds * 1000);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token){
        try{
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return!claimsJws.getBody().getExpiration().before(new Date());
        }catch (JwtException | IllegalArgumentException e){
            throw new JwtAuthenticationException("Jwt token is expired or invalid!", HttpStatus.UNAUTHORIZED);
        }
    }

    public Authentication getAuthentication(String token){
        UserEntity userEntity = this.userRepo.findByNickname(getNickname(token));
        List<GrantedAuthority> ar = new ArrayList<>();
        return new UsernamePasswordAuthenticationToken(userEntity, "", userEntity.getAuthorities());
    }

    public String getNickname(String token){
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
    public String resolveToken(HttpServletRequest request){
        return request.getHeader(authorizationHeader);
    }
}
