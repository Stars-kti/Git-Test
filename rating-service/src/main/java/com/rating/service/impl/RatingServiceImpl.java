package com.rating.service.impl;

import com.citic.common.exception.CommonException;
import com.citic.common.exception.enums.ErrorCode;
import com.citic.common.util.excel.ExcelUtils;
import com.citic.common.util.object.ObjUtils;
import com.citic.common.util.rating.RatingUtils;
import com.rating.dao.RatingDao;
import com.rating.entity.rating.ProdRating;
import com.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingDao ratingDao;

    @Override
    public List<ProdRating> findAll(Integer period) {
        if (ObjUtils.isEmpty(period)) {
            return ratingDao.findAll();
        }
        return ratingDao.findByPeriod(period);
    }

    @Override
    public Map findAll() {
        Map map = new HashMap();
        map.put("week",ratingDao.findByPeriod(0));
        map.put("month",ratingDao.findByPeriod(1));
        map.put("year",ratingDao.findByPeriod(2));
        return map;
    }

    @Override
    public Map insertExcelData(MultipartFile file, Integer period) {
        if (period == null) {
            throw new CommonException(ErrorCode.FAIL);
        }
        if (file == null) {
            throw new CommonException(ErrorCode.READ_FILE_ERROR);
        }
        int i = ratingDao.deleteByPeriod(period);
        List<Map> mapList;
        List<ProdRating> ratings = new ArrayList<>();
        mapList = ExcelUtils.excelDataHeader(file);
        mapList.forEach(map -> {
            ProdRating rating = new ProdRating();
            rating.setCode((String) map.get("代码"));
            rating.setProdId(RatingUtils.getProdId((String) map.get("代码")));
            rating.setExchangeId(RatingUtils.getExchangeId((String) map.get("代码")));
            rating.setProdName((String) map.get("品种"));
            rating.setShortScore(Double.valueOf(map.get("多头加总得分").toString()));
            rating.setLongScore(Double.valueOf( map.get("空头加总得分").toString()));
            rating.setTotalScore(Double.valueOf( map.get("综合加总得分").toString()));
            rating.setLongRating((String) map.get("多头风险评级"));
            rating.setShortRating((String) map.get("空头风险评级"));
            rating.setRating((String) map.get("综合风险评级"));
            rating.setPeriod(period);
            ratings.add(rating);
        });
        ratingDao.saveAll(ratings);
        return findAll();
    }
}
