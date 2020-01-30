package com.burak.cms.repo;

import com.burak.cms.entity.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RowRepository extends JpaRepository<Row,Long> {
    List<Row> findRowsByLayout_IdOrderByDisplayNumberAsc(Long layoutId);
}
