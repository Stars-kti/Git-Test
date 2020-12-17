package com.citic.market.dao;

import com.citic.market.entity.FundInquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FundInquiryDao extends JpaRepository<FundInquiry, Long> {

    @Query(value = "SELECT COUNT(f.id) FROM fund_inquiry f", nativeQuery = true)
    Integer findRowCount();

}
