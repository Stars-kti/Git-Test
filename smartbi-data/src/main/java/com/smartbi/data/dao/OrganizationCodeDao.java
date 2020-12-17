package com.smartbi.data.dao;

import com.smartbi.data.entity.OrganizationCode;

public interface OrganizationCodeDao {

    OrganizationCode findByCode(String code);
}
