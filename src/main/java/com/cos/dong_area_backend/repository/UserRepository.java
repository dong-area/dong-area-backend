package com.cos.dong_area_backend.repository;

import com.cos.dong_area_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{
    public User findByUsername(String username);
    public User findById(String id);

    @Query(value = "SELECT username from user where clubname=:clubname",nativeQuery = true)
    public List<String> findAllUsernameByClubname(@Param("clubname") String clubname);
}
