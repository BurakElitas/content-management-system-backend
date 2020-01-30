package com.burak.cms.repo;

import com.burak.cms.entity.NewItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsItemRepository extends JpaRepository<NewItem,Long> {
}
