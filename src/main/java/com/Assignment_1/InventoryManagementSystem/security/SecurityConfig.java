package com.Assignment_1.InventoryManagementSystem.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()  // Secure all endpoints
                )
                .httpBasic(httpBasic -> {} )  // Enable Basic Authentication
                .csrf(csrf->csrf.disable()); // Disable CSRF (only if needed)

        return http.build();
    }
}
