package com.cos.dong_area_backend.repository;

import com.cos.dong_area_backend.entity.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post,Long> {
}


