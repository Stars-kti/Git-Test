package com.citic.market.service;

import com.citic.market.dto.ReqDTO;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MarketService {

    Page dataPut(MultipartFile file, Integer id);

    Page findAll(ReqDTO reqDTO);
}
