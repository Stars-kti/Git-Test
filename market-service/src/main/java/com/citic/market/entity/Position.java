package com.citic.market.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ApiModel
public class Position {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ApiModelProperty("投资者代码")
  private String investorCode;
  @ApiModelProperty("合约")
  private String contract;
  @ApiModelProperty("总买持")
  private Long totalBuy;
  @ApiModelProperty("总卖持")
  private Long totalHold;
  @ApiModelProperty("交易所保证金")
  private Double exchangeMargin;
  @ApiModelProperty("实收交易所保证金")
  private Double realTimeExchangeMargin;
  @ApiModelProperty("今买持")
  private Long buyNow;
  @ApiModelProperty("买可平")
  private Long buyCanFlat;
  @ApiModelProperty("买均价")
  private Double averagePurchasePrice;
  @ApiModelProperty("买冻结")
  private Double buyFreeze;
  @ApiModelProperty("买保证金")
  private Double buyMargin;
  @ApiModelProperty("买开仓均价")
  private Double averageOpenPrice;
  @ApiModelProperty("今卖持")
  private Double imamatsu;
  @ApiModelProperty("卖可平")
  private Double sellCanFlat;
  @ApiModelProperty("卖均价")
  private Double averageSellingPrice;
  @ApiModelProperty("卖冻结")
  private Double sellFreeze;
  @ApiModelProperty("卖保证金")
  private Double sellMargin;
  @ApiModelProperty("卖开仓均价")
  private Double averagePositionPrice;
  @ApiModelProperty("平仓盈亏")
  private Double closingProfitAndLoss;
  @ApiModelProperty("手续费")
  private Double handlingFee;
  @ApiModelProperty("保证金")
  private Double securityDeposit;
  @ApiModelProperty("昨结算")
  private Double settlementYesterday;
  @ApiModelProperty("投保")
  private String insure;
  @ApiModelProperty("交易日")
  private String tradingDay;
  @ApiModelProperty("交易所")
  private String exchange;
  @ApiModelProperty("风险度")
  private Double risk;
  @ApiModelProperty("投资者名称")
  private String investorName;
  @ApiModelProperty("特殊标志")
  private String specialSign;
  @ApiModelProperty("品种")
  private String variety;
  @ApiModelProperty("交割期")
  private String deliveryPeriod;
  @ApiModelProperty("组织架构代码")
  private String organizationCode;
  @ApiModelProperty("组织架构名称")
  private String organizationStructureName;
  @ApiModelProperty("币种")
  private String currency;
  @ApiModelProperty("经纪公司代码")
  private String brokerageCompanyCode;
  @ApiModelProperty("实收买保证金")
  private Double actualPurchaseMargin;
  @ApiModelProperty("实收卖保证金")
  private Double realMargin;
  @ApiModelProperty("实收保证金")
  private Double paidMargin;
  @ApiModelProperty("执行冻结")
  private Long executionFreeze;
  @ApiModelProperty("放弃执行冻结")
  private Long waiveExecutionFreeze;
  @ApiModelProperty("卖权利金")
  private Double sellRoyalty;
  @ApiModelProperty("买权利金")
  private Double buyRoyalties;
  @ApiModelProperty("执行冻结金额")
  private Double performFrozenAmount;
  @ApiModelProperty("实收买保证金占比")
  private String percentageOfActualPurchaseMargin;
  @ApiModelProperty("实收卖保证金占比")
  private String percentageOfActualSalesMargin;
  @ApiModelProperty("希腊值Delta")
  private Double greekValueDelta;
  @ApiModelProperty("分时结算价")
  private Double timeSharePrice;
  @ApiModelProperty("TAS总买持")
  private Long tasTotalBuyAndHold;
  @ApiModelProperty("TAS总卖持")
  private Long tasAlwaysSold;
  @ApiModelProperty("持仓盈亏")
  private Double positionProfitAndLoss;
  @ApiModelProperty("最新价")
  private Double latestPrice;
  @ApiModelProperty("多头期权市值")
  private Double marketValueOfLongOptions;
  @ApiModelProperty("空头期权市值")
  private Double marketValueOfShortOptions;
  @ApiModelProperty("实虚值额")
  private Double realAndVirtualValue;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getInvestorCode() {
    return investorCode;
  }

  public void setInvestorCode(String investorCode) {
    this.investorCode = investorCode;
  }

  public String getContract() {
    return contract;
  }

  public void setContract(String contract) {
    this.contract = contract;
  }

  public Long getTotalBuy() {
    return totalBuy;
  }

  public void setTotalBuy(Long totalBuy) {
    this.totalBuy = totalBuy;
  }

  public Long getTotalHold() {
    return totalHold;
  }

  public void setTotalHold(Long totalHold) {
    this.totalHold = totalHold;
  }

  public Double getExchangeMargin() {
    return exchangeMargin;
  }

  public void setExchangeMargin(Double exchangeMargin) {
    this.exchangeMargin = exchangeMargin;
  }

  public Double getRealTimeExchangeMargin() {
    return realTimeExchangeMargin;
  }

  public void setRealTimeExchangeMargin(Double realTimeExchangeMargin) {
    this.realTimeExchangeMargin = realTimeExchangeMargin;
  }

  public Long getBuyNow() {
    return buyNow;
  }

  public void setBuyNow(Long buyNow) {
    this.buyNow = buyNow;
  }

  public Long getBuyCanFlat() {
    return buyCanFlat;
  }

  public void setBuyCanFlat(Long buyCanFlat) {
    this.buyCanFlat = buyCanFlat;
  }

  public Double getAveragePurchasePrice() {
    return averagePurchasePrice;
  }

  public void setAveragePurchasePrice(Double averagePurchasePrice) {
    this.averagePurchasePrice = averagePurchasePrice;
  }

  public Double getBuyFreeze() {
    return buyFreeze;
  }

  public void setBuyFreeze(Double buyFreeze) {
    this.buyFreeze = buyFreeze;
  }

  public Double getBuyMargin() {
    return buyMargin;
  }

  public void setBuyMargin(Double buyMargin) {
    this.buyMargin = buyMargin;
  }

  public Double getAverageOpenPrice() {
    return averageOpenPrice;
  }

  public void setAverageOpenPrice(Double averageOpenPrice) {
    this.averageOpenPrice = averageOpenPrice;
  }

  public Double getImamatsu() {
    return imamatsu;
  }

  public void setImamatsu(Double imamatsu) {
    this.imamatsu = imamatsu;
  }

  public Double getSellCanFlat() {
    return sellCanFlat;
  }

  public void setSellCanFlat(Double sellCanFlat) {
    this.sellCanFlat = sellCanFlat;
  }

  public Double getAverageSellingPrice() {
    return averageSellingPrice;
  }

  public void setAverageSellingPrice(Double averageSellingPrice) {
    this.averageSellingPrice = averageSellingPrice;
  }

  public Double getSellFreeze() {
    return sellFreeze;
  }

  public void setSellFreeze(Double sellFreeze) {
    this.sellFreeze = sellFreeze;
  }

  public Double getSellMargin() {
    return sellMargin;
  }

  public void setSellMargin(Double sellMargin) {
    this.sellMargin = sellMargin;
  }

  public Double getAveragePositionPrice() {
    return averagePositionPrice;
  }

  public void setAveragePositionPrice(Double averagePositionPrice) {
    this.averagePositionPrice = averagePositionPrice;
  }

  public Double getClosingProfitAndLoss() {
    return closingProfitAndLoss;
  }

  public void setClosingProfitAndLoss(Double closingProfitAndLoss) {
    this.closingProfitAndLoss = closingProfitAndLoss;
  }

  public Double getHandlingFee() {
    return handlingFee;
  }

  public void setHandlingFee(Double handlingFee) {
    this.handlingFee = handlingFee;
  }

  public Double getSecurityDeposit() {
    return securityDeposit;
  }

  public void setSecurityDeposit(Double securityDeposit) {
    this.securityDeposit = securityDeposit;
  }

  public Double getSettlementYesterday() {
    return settlementYesterday;
  }

  public void setSettlementYesterday(Double settlementYesterday) {
    this.settlementYesterday = settlementYesterday;
  }

  public String getInsure() {
    return insure;
  }

  public void setInsure(String insure) {
    this.insure = insure;
  }

  public String getTradingDay() {
    return tradingDay;
  }

  public void setTradingDay(String tradingDay) {
    this.tradingDay = tradingDay;
  }

  public String getExchange() {
    return exchange;
  }

  public void setExchange(String exchange) {
    this.exchange = exchange;
  }

  public Double getRisk() {
    return risk;
  }

  public void setRisk(Double risk) {
    this.risk = risk;
  }

  public String getInvestorName() {
    return investorName;
  }

  public void setInvestorName(String investorName) {
    this.investorName = investorName;
  }

  public String getSpecialSign() {
    return specialSign;
  }

  public void setSpecialSign(String specialSign) {
    this.specialSign = specialSign;
  }

  public String getVariety() {
    return variety;
  }

  public void setVariety(String variety) {
    this.variety = variety;
  }

  public String getDeliveryPeriod() {
    return deliveryPeriod;
  }

  public void setDeliveryPeriod(String deliveryPeriod) {
    this.deliveryPeriod = deliveryPeriod;
  }

  public String getOrganizationCode() {
    return organizationCode;
  }

  public void setOrganizationCode(String organizationCode) {
    this.organizationCode = organizationCode;
  }

  public String getOrganizationStructureName() {
    return organizationStructureName;
  }

  public void setOrganizationStructureName(String organizationStructureName) {
    this.organizationStructureName = organizationStructureName;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getBrokerageCompanyCode() {
    return brokerageCompanyCode;
  }

  public void setBrokerageCompanyCode(String brokerageCompanyCode) {
    this.brokerageCompanyCode = brokerageCompanyCode;
  }

  public Double getActualPurchaseMargin() {
    return actualPurchaseMargin;
  }

  public void setActualPurchaseMargin(Double actualPurchaseMargin) {
    this.actualPurchaseMargin = actualPurchaseMargin;
  }

  public Double getRealMargin() {
    return realMargin;
  }

  public void setRealMargin(Double realMargin) {
    this.realMargin = realMargin;
  }

  public Double getPaidMargin() {
    return paidMargin;
  }

  public void setPaidMargin(Double paidMargin) {
    this.paidMargin = paidMargin;
  }

  public Long getExecutionFreeze() {
    return executionFreeze;
  }

  public void setExecutionFreeze(Long executionFreeze) {
    this.executionFreeze = executionFreeze;
  }

  public Long getWaiveExecutionFreeze() {
    return waiveExecutionFreeze;
  }

  public void setWaiveExecutionFreeze(Long waiveExecutionFreeze) {
    this.waiveExecutionFreeze = waiveExecutionFreeze;
  }

  public Double getSellRoyalty() {
    return sellRoyalty;
  }

  public void setSellRoyalty(Double sellRoyalty) {
    this.sellRoyalty = sellRoyalty;
  }

  public Double getBuyRoyalties() {
    return buyRoyalties;
  }

  public void setBuyRoyalties(Double buyRoyalties) {
    this.buyRoyalties = buyRoyalties;
  }

  public Double getPerformFrozenAmount() {
    return performFrozenAmount;
  }

  public void setPerformFrozenAmount(Double performFrozenAmount) {
    this.performFrozenAmount = performFrozenAmount;
  }

  public String getPercentageOfActualPurchaseMargin() {
    return percentageOfActualPurchaseMargin;
  }

  public void setPercentageOfActualPurchaseMargin(String percentageOfActualPurchaseMargin) {
    this.percentageOfActualPurchaseMargin = percentageOfActualPurchaseMargin;
  }

  public String getPercentageOfActualSalesMargin() {
    return percentageOfActualSalesMargin;
  }

  public void setPercentageOfActualSalesMargin(String percentageOfActualSalesMargin) {
    this.percentageOfActualSalesMargin = percentageOfActualSalesMargin;
  }

  public Double getGreekValueDelta() {
    return greekValueDelta;
  }

  public void setGreekValueDelta(Double greekValueDelta) {
    this.greekValueDelta = greekValueDelta;
  }

  public Double getTimeSharePrice() {
    return timeSharePrice;
  }

  public void setTimeSharePrice(Double timeSharePrice) {
    this.timeSharePrice = timeSharePrice;
  }

  public Long getTasTotalBuyAndHold() {
    return tasTotalBuyAndHold;
  }

  public void setTasTotalBuyAndHold(Long tasTotalBuyAndHold) {
    this.tasTotalBuyAndHold = tasTotalBuyAndHold;
  }

  public Long getTasAlwaysSold() {
    return tasAlwaysSold;
  }

  public void setTasAlwaysSold(Long tasAlwaysSold) {
    this.tasAlwaysSold = tasAlwaysSold;
  }

  public Double getPositionProfitAndLoss() {
    return positionProfitAndLoss;
  }

  public void setPositionProfitAndLoss(Double positionProfitAndLoss) {
    this.positionProfitAndLoss = positionProfitAndLoss;
  }

  public Double getLatestPrice() {
    return latestPrice;
  }

  public void setLatestPrice(Double latestPrice) {
    this.latestPrice = latestPrice;
  }

  public Double getMarketValueOfLongOptions() {
    return marketValueOfLongOptions;
  }

  public void setMarketValueOfLongOptions(Double marketValueOfLongOptions) {
    this.marketValueOfLongOptions = marketValueOfLongOptions;
  }

  public Double getMarketValueOfShortOptions() {
    return marketValueOfShortOptions;
  }

  public void setMarketValueOfShortOptions(Double marketValueOfShortOptions) {
    this.marketValueOfShortOptions = marketValueOfShortOptions;
  }

  public Double getRealAndVirtualValue() {
    return realAndVirtualValue;
  }

  public void setRealAndVirtualValue(Double realAndVirtualValue) {
    this.realAndVirtualValue = realAndVirtualValue;
  }
}
