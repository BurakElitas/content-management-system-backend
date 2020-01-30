package com.burak.cms.repo;

import com.burak.cms.entity.Layout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LayoutRepository extends JpaRepository<Layout,Long> {
    List<Layout> findAllByUserId(Long userId);
    List<Layout> getAllByCategoryId(Long categoryId);
}
