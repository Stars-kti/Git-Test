package com.citic.market.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.citic.market.dao.FundInquiryDao;
import com.citic.market.dao.PositionDao;
import com.citic.market.dao.RiskControlMarketDao;
import com.citic.market.dto.ReqDTO;
import com.citic.market.entity.FundInquiry;
import com.citic.market.entity.Position;
import com.citic.market.entity.RiskControlMarket;
import com.citic.market.service.MarketService;
import com.citic.market.util.ExcelEventParser;
import com.citic.market.util.MarketExcelUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MarketServiceImpl implements MarketService {
    @Autowired
    FundInquiryDao fundInquiryDao;
    @Autowired
    PositionDao positionDao;
    @Autowired
    RiskControlMarketDao riskControlMarketDao;

    @Override
    public Page dataPut(MultipartFile file, Integer id) {
        List data = new ArrayList();
        ExcelEventParser excelEventParser = new ExcelEventParser(file);
        List<List<Map<Object, String>>> parse = excelEventParser.parse();
        List head = excelEventParser.getHead();
        FundInquiry fundInquiry = new FundInquiry();
        parse.forEach(list -> {
            list.forEach(map -> {
                fundInquiry.setInvestorCode(map.get(String.valueOf(head.indexOf("投资者代码"))));
            });
        });
//        MarketExcelUtils.excelData(file).forEach(list -> {
//            list.forEach(map -> {
//                String jsonString = JSONObject.toJSONString(map);
//                if (id == 0) {
//                    FundInquiry fundInquiry = JSONObject.parseObject(jsonString, FundInquiry.class);
//                    data.add(fundInquiry);
//                }
//                else if (id == 1){
//                    Position position = JSONObject.parseObject(jsonString, Position.class);
//                    data.add(position);
//                }
//                else {
//                    RiskControlMarket riskControlMarket = JSONObject.parseObject(jsonString, RiskControlMarket.class);
//                    data.add(riskControlMarket);
//                }
//            });
//        });
//        if (id == 0) {
//            fundInquiryDao.deleteAll();
//            fundInquiryDao.saveAll(data);
//        }
//        else if (id == 1) {
//            positionDao.deleteAll();
//            positionDao.saveAll(data);
//        }
//        else {
//            riskControlMarketDao.deleteAll();
//            riskControlMarketDao.saveAll(data);
//        }
        return findAll(new ReqDTO(id,1,10));
    }

    @Override
    public Page findAll(ReqDTO reqDTO) {
        Pageable pageable = PageRequest.of(reqDTO.getCurrentPage() - 1 , reqDTO.getPageSize());
        if (reqDTO.getId() == null) {
            return null;
        }
        if (reqDTO.getId() == 0) {
            return fundInquiryDao.findAll(pageable) ;
        } else if (reqDTO.getId() == 1) {
            return positionDao.findAll(pageable);
        } else {
            return riskControlMarketDao.findAll(pageable);
        }
    }

}
