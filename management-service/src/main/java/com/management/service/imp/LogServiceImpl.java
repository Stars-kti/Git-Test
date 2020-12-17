package com.management.service.imp;

import com.management.dao.LogDao;
import com.management.entity.system.Log;
import com.management.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogDao logDao;

    @Override
    public Log logSave(Log log) {
        return logDao.save(log);
    }

    @Override
    public List<Log> findAll() {
        return logDao.findAll();
    }
}
