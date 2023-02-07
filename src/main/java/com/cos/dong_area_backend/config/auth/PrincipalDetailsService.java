package com.cos.dong_area_backend.config.auth;

import com.cos.dong_area_backend.config.encoder.PasswordEncoder;
import com.cos.dong_area_backend.entity.User;
import com.cos.dong_area_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        System.out.println("PrincipalDetailsService.loadUserByUsername()");
        System.out.println("Username: "+id);
        User userEntity =  userRepository.findById(id);
        System.out.println("UserEntity: "+userEntity);


        return new PrincipalDetails(userEntity);
    }

}
