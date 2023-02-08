package com.cos.dong_area_backend.config;


import com.cos.dong_area_backend.config.jwt.JwtAuthenticationFilter;
import com.cos.dong_area_backend.config.jwt.JwtAuthorizationFilter;
import com.cos.dong_area_backend.filter.JwtFilter;
import com.cos.dong_area_backend.repository.UserRepository;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
               .cors().configurationSource(configurationSource())
               .and()
               .csrf().disable()
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               .and()
               .formLogin().disable()
               .httpBasic().disable()
                .authorizeHttpRequests(authorize -> {
                    authorize
                            .requestMatchers("/authed/**").authenticated()
                            .requestMatchers("/collabo/**").hasAnyRole("MANAGER","ADMIN")
                            .requestMatchers("/admin").hasRole("ADMIN")
                            .requestMatchers(PERMIT_URL_ARRAY).permitAll()
                            .anyRequest().permitAll();
                })
               .apply(new JwtFilter(userRepository))
               .and()
               .build();
    }

    @Bean
    public CorsConfigurationSource configurationSource() {
        CorsConfiguration source = new CorsConfiguration();
        source.addAllowedOriginPattern("*");
        source.addAllowedHeader("*");
        source.addAllowedMethod("*");
        source.addExposedHeader("*");

        UrlBasedCorsConfigurationSource corsConfigurationSource
                = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", source);
        return corsConfigurationSource;
    }
}
