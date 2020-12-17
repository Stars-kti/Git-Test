package com.log.dao;

import com.log.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDao extends JpaRepository<Log, Long> {
}
