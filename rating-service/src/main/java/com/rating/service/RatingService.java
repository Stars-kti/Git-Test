package com.rating.service;

import com.rating.entity.rating.ProdRating;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface RatingService {
    /**
     * 查询所有的评估信息
     * 传入rating根据对应的数据查询
     * 不传默认全查
     *
     * @param period 0:周度，1:月度，2:年度
     * @return List<ProdRating>
     */
    List<ProdRating> findAll(Integer period);

    /**
     * 查询所有数据 分季度导出
     * @return
     */
    Map findAll();

    /**
     * 读取Excel评估信息的数据装箱持久化
     * @param file
     * @return
     */
    Map insertExcelData(MultipartFile file, Integer period);
}
