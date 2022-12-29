package ru.mecwu.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import ru.mecwu.core.model.Role;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/user/**").permitAll()//hasRole(Role.USER.name())
                .requestMatchers("/api/cafe/**").hasRole(Role.Cafe.name())
                .requestMatchers("/api/app/**").permitAll()
                .and()
                .httpBasic(withDefaults());
        return http.build();
    }

}