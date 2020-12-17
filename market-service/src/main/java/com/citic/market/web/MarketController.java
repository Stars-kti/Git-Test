package com.citic.market.web;

import com.citic.market.dto.ReqDTO;
import com.citic.market.dto.RespDTO;
import com.citic.market.entity.FundInquiry;
import com.citic.market.entity.Position;
import com.citic.market.entity.RiskControlMarket;
import com.citic.market.service.MarketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/market")
@Api(value = "风控服务")
public class MarketController {

    @Autowired
    MarketService marketService;

    @ApiOperation("fundInquiry")
    @RequestMapping(value = "/fundInquiry", method = RequestMethod.POST)
    public FundInquiry fundInquiry() {
        return null;
    }
    @ApiOperation("position")
    @RequestMapping(value = "/position", method = RequestMethod.POST)
    public Position position() {
        return null;
    }
    @ApiOperation("riskControlMarket")
    @RequestMapping(value = "/riskControlMarket", method = RequestMethod.POST)
    public RiskControlMarket riskControlMarket() {
        return null;
    }


    @ApiOperation(value = "导入数据",notes = "根据id的值导入不同的数据 0:资金查询, 1:持仓查询, 2:实时风控行情")
    @RequestMapping(value = "/dataPut", method = RequestMethod.POST)
    public RespDTO dataPut(MultipartFile file, Integer id) {
        return RespDTO.onSuc(marketService.dataPut(file, id));
    }

    @ApiOperation(value = "查询全部数据",notes = "查询全部数据 0:资金查询, 1:持仓查询, 2:实时风控行情")
    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public RespDTO findById(@RequestBody ReqDTO req) {
        return RespDTO.onSuc(marketService.findAll(req));
    }


}
