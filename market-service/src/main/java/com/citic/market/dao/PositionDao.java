package com.citic.market.dao;

import com.citic.market.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PositionDao extends JpaRepository<Position, Long> {

    @Query(value = "SELECT COUNT(p.id) FROM position p", nativeQuery = true)
    Integer findRowCount();
}
