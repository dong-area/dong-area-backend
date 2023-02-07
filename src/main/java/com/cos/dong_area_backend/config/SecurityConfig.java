package com.cos.dong_area_backend.config;


import com.cos.dong_area_backend.filter.JwtFilter;
import com.cos.dong_area_backend.repository.UserRepository;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserRepository userRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       return http
               .cors().disable()
               .csrf().disable()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .formLogin().disable()
               .httpBasic().disable()
                .authorizeHttpRequests(authorize -> {
                    authorize
                            .requestMatchers("/authed/**").authenticated()
                            .anyRequest().permitAll();
                })
               .apply(new JwtFilter(userRepository))
               .and()
               .build();
    }
}
