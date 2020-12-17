package com.smartbi.data.service.impl;

import com.smartbi.data.dao.*;
import com.smartbi.data.entity.*;
import com.smartbi.data.service.RightsAndInterestsService;
import com.smartbi.data.util.TxtDataInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenjiaxing
 */
@Service
public class RightsAndInterestsServiceImpl implements RightsAndInterestsService {

    @Autowired
    RaiAllDao raiAllDao;

    @Override
    public List<RightsAndInterests> saveAll() {


//        organizationCodeDao.deleteAll();
//        organizationNameDao.deleteAll();
//        organizationLevelDao.deleteAll();
//        TxtDataInput txtDataInput = new TxtDataInput("C:/Users/citicsf/Documents/WeChat Files/wxid_qogswec0lyri22/FileStorage/File/2020-11/org_marketdeposit_20201116.data");
//        List<String[]> data = txtDataInput.getData("\\|", 1);
//        List<RightsAndInterests> rightsAndInterests = new ArrayList<>();
//        Set<OrganizationCode> organizationCodes = new HashSet<>();
//        Set<OrganizationLevel> organizationLevels = new HashSet<>();
//        Set<OrganizationName> organizationNames = new HashSet<>();
//        for (String[] s: data) {
//            organizationCodes.add(new OrganizationCode(s[1]));
//            organizationLevels.add(new OrganizationLevel(s[6]));
//            organizationNames.add(new OrganizationName(s[2]));
//        }
//        List<OrganizationLevel> levels = organizationLevelDao.saveAll(organizationLevels);
//        List<OrganizationName> names = organizationNameDao.saveAll(organizationNames);
//        List<OrganizationCode> codes = organizationCodeDao.saveAll(organizationCodes);
//        for (String[] s: data) {
//            RightsAndInterests r = new RightsAndInterests(Timestamp.valueOf("2020-11-16 00:00:00"),
//                    Double.valueOf(s[3] == null || "NULL".equals(s[3]) ?  "0" : s[3]),
//                    Double.valueOf(s[4] == null || "NULL".equals(s[4]) ?  "0" : s[4]),
//                    Double.valueOf(s[5] == null || "NULL".equals(s[5]) ?  "0" : s[5]),
//                    organizationCodeDao.findByCode(s[1]),organizationNameDao.findByName(s[2]),
//                    organizationLevelDao.findByLevel(s[6]));
//            rightsAndInterests.add(r);
//        }
//        return rightsAndInterestsDao.saveAll(rightsAndInterests);
        return null;
    }

    @Override
    public List<RaiAll> saveRaiAll() {
//        raiAllDao.deleteAll();
//        TxtDataInput txtDataInput = new TxtDataInput("C:/Users/citicsf/Documents/WeChat Files/wxid_qogswec0lyri22/FileStorage/File/2020-11/org_marketdeposit_20201116.data");
//        List<String[]> data = txtDataInput.getData("\\|", 1);
//        List<RaiAll> raiAlls = new ArrayList<>();
//        for (String[] s : data) {
//            RaiAll raiAll = new RaiAll(Timestamp.valueOf("2020-11-16 00:00:00"),
//                    Double.valueOf(s[3] == null || "NULL".equals(s[3]) ?  "0" : s[3]),
//                    Double.valueOf(s[4] == null || "NULL".equals(s[4]) ?  "0" : s[4]),
//                    Double.valueOf(s[5] == null || "NULL".equals(s[5]) ?  "0" : s[5]),
//                    s[1],s[2],s[6]);
//            raiAlls.add(raiAll);
//        }
//        return raiAllDao.saveAll(raiAlls);
        return null;
    }

    @Override
    public List<RaiAll> showAll() {
        return raiAllDao.all();
    }
}
