package com.log.service;



import com.log.entity.Log;

import java.util.List;

public interface LogService {

    /** Save **/
    Log logSave(Log log);

    /** selectAll **/
    List<Log> findAll();

}
