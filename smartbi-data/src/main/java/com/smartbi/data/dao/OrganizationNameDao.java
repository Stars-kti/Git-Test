package com.smartbi.data.dao;

import com.smartbi.data.entity.OrganizationName;

public interface OrganizationNameDao {

    OrganizationName findByName(String name);
}
