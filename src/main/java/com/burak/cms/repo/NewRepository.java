package com.burak.cms.repo;

import com.burak.cms.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewRepository extends JpaRepository<News,Long> {
    List<News> getAllByUserId(Long userId);
}
