package com.rating.dao;

import com.rating.entity.system.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDao extends JpaRepository<Log, Long> {
}
