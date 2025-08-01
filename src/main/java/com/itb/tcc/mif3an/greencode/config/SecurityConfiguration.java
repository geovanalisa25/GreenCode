package com.itb.tcc.mif3an.greencode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static com.itb.tcc.mif3an.greencode.model.entity.Role.ADMIN;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String [] WHITE_LIST_URL = {
            "/api/v1/auth/**",
            "/images/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req
                                .requestMatchers("/api/v1/admin/**").permitAll()
                                .requestMatchers(WHITE_LIST_URL).permitAll()

                             );

        return http.build();
    }
}
