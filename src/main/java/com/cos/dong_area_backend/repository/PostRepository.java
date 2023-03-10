package com.cos.dong_area_backend.repository;

import com.cos.dong_area_backend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    public Page<Post> findAllByType(String type, Pageable pageable);

    //public void deleteByIdx(Long idx);

    @Query(value = "select writer from post where idx=:idx",nativeQuery = true)
    public String findWriterByIdx(@Param("idx")Long idx);
}


