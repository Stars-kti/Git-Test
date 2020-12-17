package com.citic.market.dao;

import com.citic.market.entity.RiskControlMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RiskControlMarketDao extends JpaRepository<RiskControlMarket, Long> {

    @Query(value = "SELECT COUNT(r.id) FROM risk_control_market r", nativeQuery = true)
    Integer findRowCount();
}
