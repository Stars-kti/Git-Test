package com.smartbi.data.dao;

import com.smartbi.data.entity.RaiAll;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RaiAllDao {

    List<RaiAll> all();

}
