package com.cos.dong_area_backend.repository;

import com.cos.dong_area_backend.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface ClubRepository extends JpaRepository<Club,Long> {
    public Club findByName(String name);
}
