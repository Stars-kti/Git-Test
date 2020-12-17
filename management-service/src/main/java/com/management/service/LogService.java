package com.management.service;


import com.management.entity.system.Log;

import java.util.List;

public interface LogService {

    /** Save **/
    Log logSave(Log log);

    /** selectAll **/
    List<Log> findAll();

}
