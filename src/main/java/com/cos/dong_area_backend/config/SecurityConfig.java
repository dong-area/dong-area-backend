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
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private static final String[] PERMIT_URL_ARRAY = {
            /* swagger v2 */
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            /* swagger v3 */
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };

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
                            .requestMatchers(PERMIT_URL_ARRAY).permitAll()
                            .anyRequest().permitAll();
                })
               .apply(new JwtFilter(userRepository))
               .and()
               .build();
    }
}
