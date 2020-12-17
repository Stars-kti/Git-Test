package com.smartbi.data.service;

import com.smartbi.data.entity.RaiAll;
import com.smartbi.data.entity.RightsAndInterests;

import java.util.List;

/**
 * @author chenjiaxing
 */
public interface RightsAndInterestsService {

    /**
     * 导入全部
     * @return
     */
    List<RightsAndInterests> saveAll();

    /**
     * 导入全部
     * @return
     */
    List<RaiAll> saveRaiAll();

    /**
     * showall
     * @return
     */
    List<RaiAll> showAll();
}
