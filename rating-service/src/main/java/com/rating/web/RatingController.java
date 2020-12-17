package com.rating.web;

import com.citic.common.annotation.Log;
import com.citic.common.annotation.type.LogActionType;
import com.rating.dto.RespDTO;
import com.rating.entity.rating.ProdRating;
import com.rating.service.RatingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/prodrating")
@Api(tags = "评估信息")
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @Log("查询风险评估信息")
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有评估信息", notes = "传入period参数执行分季度查询，不传全查")
    @ApiParam(name = "period", value = "季度参数(0,1,2)")
    public RespDTO<Map> findAll() {
        return RespDTO.onSuc(ratingService.findAll());
    }

    @Log(value = "导入评估信息数据",type = LogActionType.INSERT)
    @RequestMapping(value = "/importProdRating", method = RequestMethod.POST)
    @ApiOperation(value = "导入评估信息数据", notes = "需传入季度参数")
    @ApiParam(name = "period", value = "季度参数(0,1,2)")
    public RespDTO<ProdRating> insertExcelData(MultipartFile file, String period) {
        Map map = ratingService.insertExcelData(file, 0);
        return RespDTO.onSuc(map);
    }

}
