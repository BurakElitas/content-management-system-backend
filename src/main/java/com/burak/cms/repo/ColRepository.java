package com.burak.cms.repo;

import com.burak.cms.entity.Col;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ColRepository extends JpaRepository<Col,Long> {

    List<Col> findAllByRow_IdOrderByDisplayNumberAsc(Long rowId);



}
