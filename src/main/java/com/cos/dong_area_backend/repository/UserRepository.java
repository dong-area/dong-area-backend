package com.cos.dong_area_backend.repository;

import com.cos.dong_area_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    public User findByUsername(String username);
}
