package com.management.dao;

import com.management.entity.system.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDao extends JpaRepository<Log,Long> {
}
