package com.smartbi.data.dao;

import com.smartbi.data.entity.OrganizationCode;
import com.smartbi.data.entity.OrganizationLevel;

public interface OrganizationLevelDao {

    OrganizationLevel findByLevel(String level);
}
