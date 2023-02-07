package com.cos.dong_area_backend.config;


import jakarta.servlet.FilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       return http
                .csrf().disable()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .formLogin().disable()
               .httpBasic().disable()
                .authorizeHttpRequests(authorize ->{
                    try {
                        authorize
                                .anyRequest().permitAll()
                                .and()
                                .formLogin()
                                .loginPage("/loginForm")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).build();
    }
}
