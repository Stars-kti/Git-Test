package com.management.web;

import com.citic.common.util.excel.ExcelUtils;
import com.management.dto.system.RespDTO;
import com.management.entity.system.Log;
import com.management.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/management")
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
@Api(tags = "日志模块")
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping(value = "all",method = RequestMethod.POST)
    @ApiOperation(value = "查询日志", notes = "查询所有日志")
    public RespDTO findAll() {
        List<Log> all = logService.findAll();
        return RespDTO.onSuc(all);
    }

    @RequestMapping(value = "logExcel",method = RequestMethod.GET)
    @ApiOperation(value = "查询日志导出excel", notes = "查询所有日志导出excel")
    public void logExcel(HttpServletResponse response) {
        List<Log> all = logService.findAll();
        String[] strings = {"ID","操作用户","描述","方法名","参数","日志类型","操作类型","请求ip","地址","浏览器","请求耗时", "异常详细", "创建日期"};
        ExcelUtils.excelExport(response,"Log",strings ,all);
    }
}
