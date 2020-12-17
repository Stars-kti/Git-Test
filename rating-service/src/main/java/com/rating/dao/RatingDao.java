package com.rating.dao;

import com.rating.entity.rating.ProdRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.List;

public interface RatingDao extends JpaRepository<ProdRating, Long> {

    List<ProdRating> findByPeriod(Integer period);

    @Transactional
    @Modifying
    int deleteByPeriod(Integer period);


}
