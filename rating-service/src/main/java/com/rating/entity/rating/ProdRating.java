package com.rating.entity.rating;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "t_prodrating")
@ApiModel("风险评估")
public class ProdRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("代码")
    private String code;
    @ApiModelProperty(value = "品种id",notes = "品种字母小写: shf, ine, dce; 品种字母大写: cfe,czc")
    @Column(name = "prodid")
    private String prodId;
    @ApiModelProperty(value = "交易所id",notes = "DCE, CZCE, CFFEX, INE, SHFE")
    @Column(name = "exchangeid")
    private String exchangeId;
    @ApiModelProperty("品种")
    @Column(name = "prodname")
    private String prodName;
    @ApiModelProperty("多头加总得分")
    private Double longScore;
    @ApiModelProperty("空头加总得分")
    private Double shortScore;
    @ApiModelProperty("综合加总得分")
    private Double totalScore;
    @ApiModelProperty("多头风险评级")
    private String longRating;
    @ApiModelProperty("空头风险评级")
    private String shortRating;
    @ApiModelProperty("综合风险评级")
    private String rating;
    @ApiModelProperty(value = "评估范围",notes = "0-周，1-月，2-年")
    private Integer period;
    @ApiModelProperty("评估时间")
    @CreationTimestamp
    private Timestamp createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    public Double getLongScore() {
        return longScore;
    }

    public void setLongScore(Double longScore) {
        this.longScore = longScore;
    }

    public Double getShortScore() {
        return shortScore;
    }

    public void setShortScore(Double shortScore) {
        this.shortScore = shortScore;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    public String getLongRating() {
        return longRating;
    }

    public void setLongRating(String longRating) {
        this.longRating = longRating;
    }

    public String getShortRating() {
        return shortRating;
    }

    public void setShortRating(String shortRating) {
        this.shortRating = shortRating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
