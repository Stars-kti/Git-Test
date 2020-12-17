package com.citic.market.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@ApiModel
public class RiskControlMarket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ApiModelProperty("合约")
  private String contract;
  @ApiModelProperty("最新价")
  private Double latestPrice;
  @ApiModelProperty("成交量")
  private Long volume;
  @ApiModelProperty("成交额")
  private Double turnover;
  @ApiModelProperty("持仓量")
  private Long openInterest;
  @ApiModelProperty("昨结算")
  private Double settlementYesterday;
  @ApiModelProperty("昨收盘")
  private Double closedYesterday;
  @ApiModelProperty("昨持仓")
  private Long positionYesterday;
  @ApiModelProperty("今开盘")
  private Double openToday;
  @ApiModelProperty("最高价")
  private Double highestPrice;
  @ApiModelProperty("最低价")
  private Double floorPrice;
  @ApiModelProperty("今收盘")
  private Double closeToday;
  @ApiModelProperty("今结算")
  private Double settlementToday;
  @ApiModelProperty("涨停价")
  private Double priceLimit;
  @ApiModelProperty("跌停价")
  private Double limitPrice;
  @ApiModelProperty("买价")
  private Double buyingPrice;
  @ApiModelProperty("买量")
  private Long purchaseAmount;
  @ApiModelProperty("卖价")
  private Double sellingPrice;
  @ApiModelProperty("卖量")
  private Long salesVolume;
  @ApiModelProperty("均价")
  private Double averagePrice;
  @ApiModelProperty("涨跌")
  private Double upsAndDowns;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContract() {
    return contract;
  }

  public void setContract(String contract) {
    this.contract = contract;
  }

  public Double getLatestPrice() {
    return latestPrice;
  }

  public void setLatestPrice(Double latestPrice) {
    this.latestPrice = latestPrice;
  }

  public Long getVolume() {
    return volume;
  }

  public void setVolume(Long volume) {
    this.volume = volume;
  }

  public Double getTurnover() {
    return turnover;
  }

  public void setTurnover(Double turnover) {
    this.turnover = turnover;
  }

  public Long getOpenInterest() {
    return openInterest;
  }

  public void setOpenInterest(Long openInterest) {
    this.openInterest = openInterest;
  }

  public Double getSettlementYesterday() {
    return settlementYesterday;
  }

  public void setSettlementYesterday(Double settlementYesterday) {
    this.settlementYesterday = settlementYesterday;
  }

  public Double getClosedYesterday() {
    return closedYesterday;
  }

  public void setClosedYesterday(Double closedYesterday) {
    this.closedYesterday = closedYesterday;
  }

  public Long getPositionYesterday() {
    return positionYesterday;
  }

  public void setPositionYesterday(Long positionYesterday) {
    this.positionYesterday = positionYesterday;
  }

  public Double getOpenToday() {
    return openToday;
  }

  public void setOpenToday(Double openToday) {
    this.openToday = openToday;
  }

  public Double getHighestPrice() {
    return highestPrice;
  }

  public void setHighestPrice(Double highestPrice) {
    this.highestPrice = highestPrice;
  }

  public Double getFloorPrice() {
    return floorPrice;
  }

  public void setFloorPrice(Double floorPrice) {
    this.floorPrice = floorPrice;
  }

  public Double getCloseToday() {
    return closeToday;
  }

  public void setCloseToday(Double closeToday) {
    this.closeToday = closeToday;
  }

  public Double getSettlementToday() {
    return settlementToday;
  }

  public void setSettlementToday(Double settlementToday) {
    this.settlementToday = settlementToday;
  }

  public Double getPriceLimit() {
    return priceLimit;
  }

  public void setPriceLimit(Double priceLimit) {
    this.priceLimit = priceLimit;
  }

  public Double getLimitPrice() {
    return limitPrice;
  }

  public void setLimitPrice(Double limitPrice) {
    this.limitPrice = limitPrice;
  }

  public Double getBuyingPrice() {
    return buyingPrice;
  }

  public void setBuyingPrice(Double buyingPrice) {
    this.buyingPrice = buyingPrice;
  }

  public Long getPurchaseAmount() {
    return purchaseAmount;
  }

  public void setPurchaseAmount(Long purchaseAmount) {
    this.purchaseAmount = purchaseAmount;
  }

  public Double getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public Long getSalesVolume() {
    return salesVolume;
  }

  public void setSalesVolume(Long salesVolume) {
    this.salesVolume = salesVolume;
  }

  public Double getAveragePrice() {
    return averagePrice;
  }

  public void setAveragePrice(Double averagePrice) {
    this.averagePrice = averagePrice;
  }

  public Double getUpsAndDowns() {
    return upsAndDowns;
  }

  public void setUpsAndDowns(Double upsAndDowns) {
    this.upsAndDowns = upsAndDowns;
  }
}
