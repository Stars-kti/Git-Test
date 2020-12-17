package com.smartbi.data.web;

import com.smartbi.data.service.RightsAndInterestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenjiaxing
 */
@RestController
public class TestWbe {

    @Autowired
    RightsAndInterestsService rightsAndInterestsService;

    @RequestMapping(value = "/saveAll",method = RequestMethod.GET)
    public List saveAll() {
        return rightsAndInterestsService.saveAll();
    }

    @RequestMapping(value = "/saveRaiAll",method = RequestMethod.GET)
    public List saveRaiAll() {
        return rightsAndInterestsService.saveRaiAll();
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List raiAll() {
        return rightsAndInterestsService.showAll();
    }
}
