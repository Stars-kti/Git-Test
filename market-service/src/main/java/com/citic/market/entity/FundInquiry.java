package com.citic.market.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ApiModel
public class FundInquiry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ApiModelProperty("投资者代码")
  private String investorCode;
  @ApiModelProperty("经纪公司代码")
  private String brokerageCompanyCode;
  @ApiModelProperty("风险状态")
  private String riskStatus;
  @ApiModelProperty("风险度")
  private Double risk;
  @ApiModelProperty("投资者帐号")
  private String investorAccount;
  @ApiModelProperty("交易所风险状态")
  private String exchangeRiskStatus;
  @ApiModelProperty("交易所风险度")
  private Double exchangeRisk;
  @ApiModelProperty("交易所可用资金")
  private Double availableFundsOnTheExchange;
  @ApiModelProperty("上次质押")
  private Double lastPledge;
  @ApiModelProperty("上次资金冻结")
  private Double lastFundsFreeze;
  @ApiModelProperty("昨结存")
  private Double yesterdayBalance;
  @ApiModelProperty("昨权益")
  private Double yesterdayRights;
  @ApiModelProperty("上次占用保证金")
  private Double lastOccupiedMargin;
  @ApiModelProperty("出入金")
  private Double depositAndWithdrawal;
  @ApiModelProperty("保证金")
  private Double securityDeposit;
  @ApiModelProperty("手续费")
  private Double handlingFee;
  @ApiModelProperty("平仓盈亏")
  private Double closingProfitAndLoss;
  @ApiModelProperty("持仓盈亏")
  private Double positionProfitAndLoss;
  @ApiModelProperty("权益")
  private Double rightsAndInterests;
  @ApiModelProperty("可用资金")
  private Double availableFunds;
  @ApiModelProperty("质押金额")
  private Double pledgeAmount;
  @ApiModelProperty("交易所保证金")
  private Double exchangeMargin;
  @ApiModelProperty("保底资金")
  private Double guaranteedFund;
  @ApiModelProperty("可取资金")
  private Double availableFundsOut;
  @ApiModelProperty("资金冻结")
  private Double fundFreeze;
  @ApiModelProperty("投资者名称")
  private String investorName;
  @ApiModelProperty("昨风险状态")
  private String yesterdaysRiskStatus;
  @ApiModelProperty("强平标志")
  private String liquidationSign;
  @ApiModelProperty("昨强平标志")
  private String yesterdayLiquidationSign;
  @ApiModelProperty("历史强平次数")
  private Long historicalLiquidations;
  @ApiModelProperty("风险持仓")
  private Long riskPosition;
  @ApiModelProperty("上次交易所保证金")
  private Double lastExchangeMargin;
  @ApiModelProperty("通知状态")
  private String notificationStatus;
  @ApiModelProperty("组织架构代码")
  private String organizationCode;
  @ApiModelProperty("组织架构名称")
  private String organizationStructureName;
  @ApiModelProperty("特殊标志")
  private String specialSign;
  @ApiModelProperty("交割保证金")
  private Double deliveryMargin;
  @ApiModelProperty("交易所交割保证金")
  private Double exchangeDeliveryMargin;
  @ApiModelProperty("保证金冻结")
  private Double marginFreeze;
  @ApiModelProperty("手续费冻结")
  private Double freezeFee;
  @ApiModelProperty("电话通知标志")
  private String phoneNotificationSign;
  @ApiModelProperty("币种")
  private String currency;
  @ApiModelProperty("上次质入")
  private Double lastPledgePut;
  @ApiModelProperty("上次质出")
  private Double lastQualityOut;
  @ApiModelProperty("质入金额")
  private Double pledgeAmountPut;
  @ApiModelProperty("质出金额")
  private Double pledgeAmountOut;
  @ApiModelProperty("质押余额")
  private Double pledgeBalance;
  @ApiModelProperty("可质押金额")
  private Double pledgeableDeposit;
  @ApiModelProperty("特殊产品保证金")
  private Double specialProductMargin;
  @ApiModelProperty("特殊产品保证金冻结")
  private Double specialProductMarginFreeze;
  @ApiModelProperty("特殊产品手续费")
  private Double specialProductHandlingFee;
  @ApiModelProperty("特殊产品手续费冻结")
  private Double specialProductFeeFreeze;
  @ApiModelProperty("特殊产品持仓盈亏")
  private Double specialProductHoldingProfitAndLoss;
  @ApiModelProperty("特殊产品平仓盈亏")
  private Double specialProductClosingProfitAndLoss;
  @ApiModelProperty("特殊品种交易所保证金")
  private Double specialVarietyExchangeMargin;
  @ApiModelProperty("上次特殊产品保证金")
  private Double lastSpecialProductMargin;
  @ApiModelProperty("上次特殊产品占用交易所保证金")
  private Double theLastSpecialProductOccupiedTheExchangeMargin;
  @ApiModelProperty("昨交易所风险状态")
  private String yesterdaysExchangeRiskStatus;
  @ApiModelProperty("昨风险度")
  private Double yesterdaysRisk;
  @ApiModelProperty("昨交易所风险度")
  private Double yesterdayExchangeRisk;
  @ApiModelProperty("市值权益")
  private Double marketValueEquity;
  @ApiModelProperty("期权市值")
  private Double optionMarketValue;
  @ApiModelProperty("冻结权利金")
  private Double freezeRoyalties;
  @ApiModelProperty("权利金")
  private Double premium;
  @ApiModelProperty("可用资金参考")
  private Double availableFundsReference;
  @ApiModelProperty("风险度2")
  private Double risk2;
  @ApiModelProperty("交易所风险度2")
  private Double exchangeRisk2;
  @ApiModelProperty("持仓品种数量")
  private Long numberOfOpenVariety;
  @ApiModelProperty("持仓合约数量")
  private Long numberOfOpenPositions;
  @ApiModelProperty("保证金2")
  private Double margin2;
  @ApiModelProperty("保证金3")
  private Double margin3;
  @ApiModelProperty("风险度3")
  private Double risk3;
  @ApiModelProperty("延时换汇冻结金额")
  private Double frozenAmountOfDelayedForeignExchange;
  @ApiModelProperty("剩余换汇额度")
  private Double remainingExchangeQuota;


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

  public String getBrokerageCompanyCode() {
    return brokerageCompanyCode;
  }

  public void setBrokerageCompanyCode(String brokerageCompanyCode) {
    this.brokerageCompanyCode = brokerageCompanyCode;
  }

  public String getRiskStatus() {
    return riskStatus;
  }

  public void setRiskStatus(String riskStatus) {
    this.riskStatus = riskStatus;
  }

  public Double getRisk() {
    return risk;
  }

  public void setRisk(Double risk) {
    this.risk = risk;
  }

  public String getInvestorAccount() {
    return investorAccount;
  }

  public void setInvestorAccount(String investorAccount) {
    this.investorAccount = investorAccount;
  }

  public String getExchangeRiskStatus() {
    return exchangeRiskStatus;
  }

  public void setExchangeRiskStatus(String exchangeRiskStatus) {
    this.exchangeRiskStatus = exchangeRiskStatus;
  }

  public Double getExchangeRisk() {
    return exchangeRisk;
  }

  public void setExchangeRisk(Double exchangeRisk) {
    this.exchangeRisk = exchangeRisk;
  }

  public Double getAvailableFundsOnTheExchange() {
    return availableFundsOnTheExchange;
  }

  public void setAvailableFundsOnTheExchange(Double availableFundsOnTheExchange) {
    this.availableFundsOnTheExchange = availableFundsOnTheExchange;
  }

  public Double getLastPledge() {
    return lastPledge;
  }

  public void setLastPledge(Double lastPledge) {
    this.lastPledge = lastPledge;
  }

  public Double getLastFundsFreeze() {
    return lastFundsFreeze;
  }

  public void setLastFundsFreeze(Double lastFundsFreeze) {
    this.lastFundsFreeze = lastFundsFreeze;
  }

  public Double getYesterdayBalance() {
    return yesterdayBalance;
  }

  public void setYesterdayBalance(Double yesterdayBalance) {
    this.yesterdayBalance = yesterdayBalance;
  }

  public Double getYesterdayRights() {
    return yesterdayRights;
  }

  public void setYesterdayRights(Double yesterdayRights) {
    this.yesterdayRights = yesterdayRights;
  }

  public Double getLastOccupiedMargin() {
    return lastOccupiedMargin;
  }

  public void setLastOccupiedMargin(Double lastOccupiedMargin) {
    this.lastOccupiedMargin = lastOccupiedMargin;
  }

  public Double getDepositAndWithdrawal() {
    return depositAndWithdrawal;
  }

  public void setDepositAndWithdrawal(Double depositAndWithdrawal) {
    this.depositAndWithdrawal = depositAndWithdrawal;
  }

  public Double getSecurityDeposit() {
    return securityDeposit;
  }

  public void setSecurityDeposit(Double securityDeposit) {
    this.securityDeposit = securityDeposit;
  }

  public Double getHandlingFee() {
    return handlingFee;
  }

  public void setHandlingFee(Double handlingFee) {
    this.handlingFee = handlingFee;
  }

  public Double getClosingProfitAndLoss() {
    return closingProfitAndLoss;
  }

  public void setClosingProfitAndLoss(Double closingProfitAndLoss) {
    this.closingProfitAndLoss = closingProfitAndLoss;
  }

  public Double getPositionProfitAndLoss() {
    return positionProfitAndLoss;
  }

  public void setPositionProfitAndLoss(Double positionProfitAndLoss) {
    this.positionProfitAndLoss = positionProfitAndLoss;
  }

  public Double getRightsAndInterests() {
    return rightsAndInterests;
  }

  public void setRightsAndInterests(Double rightsAndInterests) {
    this.rightsAndInterests = rightsAndInterests;
  }

  public Double getAvailableFunds() {
    return availableFunds;
  }

  public void setAvailableFunds(Double availableFunds) {
    this.availableFunds = availableFunds;
  }

  public Double getPledgeAmount() {
    return pledgeAmount;
  }

  public void setPledgeAmount(Double pledgeAmount) {
    this.pledgeAmount = pledgeAmount;
  }

  public Double getExchangeMargin() {
    return exchangeMargin;
  }

  public void setExchangeMargin(Double exchangeMargin) {
    this.exchangeMargin = exchangeMargin;
  }

  public Double getGuaranteedFund() {
    return guaranteedFund;
  }

  public void setGuaranteedFund(Double guaranteedFund) {
    this.guaranteedFund = guaranteedFund;
  }

  public Double getAvailableFundsOut() {
    return availableFundsOut;
  }

  public void setAvailableFundsOut(Double availableFundsOut) {
    this.availableFundsOut = availableFundsOut;
  }

  public Double getFundFreeze() {
    return fundFreeze;
  }

  public void setFundFreeze(Double fundFreeze) {
    this.fundFreeze = fundFreeze;
  }

  public String getInvestorName() {
    return investorName;
  }

  public void setInvestorName(String investorName) {
    this.investorName = investorName;
  }

  public String getYesterdaysRiskStatus() {
    return yesterdaysRiskStatus;
  }

  public void setYesterdaysRiskStatus(String yesterdaysRiskStatus) {
    this.yesterdaysRiskStatus = yesterdaysRiskStatus;
  }

  public String getLiquidationSign() {
    return liquidationSign;
  }

  public void setLiquidationSign(String liquidationSign) {
    this.liquidationSign = liquidationSign;
  }

  public String getYesterdayLiquidationSign() {
    return yesterdayLiquidationSign;
  }

  public void setYesterdayLiquidationSign(String yesterdayLiquidationSign) {
    this.yesterdayLiquidationSign = yesterdayLiquidationSign;
  }

  public Long getHistoricalLiquidations() {
    return historicalLiquidations;
  }

  public void setHistoricalLiquidations(Long historicalLiquidations) {
    this.historicalLiquidations = historicalLiquidations;
  }

  public Long getRiskPosition() {
    return riskPosition;
  }

  public void setRiskPosition(Long riskPosition) {
    this.riskPosition = riskPosition;
  }

  public Double getLastExchangeMargin() {
    return lastExchangeMargin;
  }

  public void setLastExchangeMargin(Double lastExchangeMargin) {
    this.lastExchangeMargin = lastExchangeMargin;
  }

  public String getNotificationStatus() {
    return notificationStatus;
  }

  public void setNotificationStatus(String notificationStatus) {
    this.notificationStatus = notificationStatus;
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

  public String getSpecialSign() {
    return specialSign;
  }

  public void setSpecialSign(String specialSign) {
    this.specialSign = specialSign;
  }

  public Double getDeliveryMargin() {
    return deliveryMargin;
  }

  public void setDeliveryMargin(Double deliveryMargin) {
    this.deliveryMargin = deliveryMargin;
  }

  public Double getExchangeDeliveryMargin() {
    return exchangeDeliveryMargin;
  }

  public void setExchangeDeliveryMargin(Double exchangeDeliveryMargin) {
    this.exchangeDeliveryMargin = exchangeDeliveryMargin;
  }

  public Double getMarginFreeze() {
    return marginFreeze;
  }

  public void setMarginFreeze(Double marginFreeze) {
    this.marginFreeze = marginFreeze;
  }

  public Double getFreezeFee() {
    return freezeFee;
  }

  public void setFreezeFee(Double freezeFee) {
    this.freezeFee = freezeFee;
  }

  public String getPhoneNotificationSign() {
    return phoneNotificationSign;
  }

  public void setPhoneNotificationSign(String phoneNotificationSign) {
    this.phoneNotificationSign = phoneNotificationSign;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Double getLastPledgePut() {
    return lastPledgePut;
  }

  public void setLastPledgePut(Double lastPledgePut) {
    this.lastPledgePut = lastPledgePut;
  }

  public Double getLastQualityOut() {
    return lastQualityOut;
  }

  public void setLastQualityOut(Double lastQualityOut) {
    this.lastQualityOut = lastQualityOut;
  }

  public Double getPledgeAmountPut() {
    return pledgeAmountPut;
  }

  public void setPledgeAmountPut(Double pledgeAmountPut) {
    this.pledgeAmountPut = pledgeAmountPut;
  }

  public Double getPledgeAmountOut() {
    return pledgeAmountOut;
  }

  public void setPledgeAmountOut(Double pledgeAmountOut) {
    this.pledgeAmountOut = pledgeAmountOut;
  }

  public Double getPledgeBalance() {
    return pledgeBalance;
  }

  public void setPledgeBalance(Double pledgeBalance) {
    this.pledgeBalance = pledgeBalance;
  }

  public Double getPledgeableDeposit() {
    return pledgeableDeposit;
  }

  public void setPledgeableDeposit(Double pledgeableDeposit) {
    this.pledgeableDeposit = pledgeableDeposit;
  }

  public Double getSpecialProductMargin() {
    return specialProductMargin;
  }

  public void setSpecialProductMargin(Double specialProductMargin) {
    this.specialProductMargin = specialProductMargin;
  }

  public Double getSpecialProductMarginFreeze() {
    return specialProductMarginFreeze;
  }

  public void setSpecialProductMarginFreeze(Double specialProductMarginFreeze) {
    this.specialProductMarginFreeze = specialProductMarginFreeze;
  }

  public Double getSpecialProductHandlingFee() {
    return specialProductHandlingFee;
  }

  public void setSpecialProductHandlingFee(Double specialProductHandlingFee) {
    this.specialProductHandlingFee = specialProductHandlingFee;
  }

  public Double getSpecialProductFeeFreeze() {
    return specialProductFeeFreeze;
  }

  public void setSpecialProductFeeFreeze(Double specialProductFeeFreeze) {
    this.specialProductFeeFreeze = specialProductFeeFreeze;
  }

  public Double getSpecialProductHoldingProfitAndLoss() {
    return specialProductHoldingProfitAndLoss;
  }

  public void setSpecialProductHoldingProfitAndLoss(Double specialProductHoldingProfitAndLoss) {
    this.specialProductHoldingProfitAndLoss = specialProductHoldingProfitAndLoss;
  }

  public Double getSpecialProductClosingProfitAndLoss() {
    return specialProductClosingProfitAndLoss;
  }

  public void setSpecialProductClosingProfitAndLoss(Double specialProductClosingProfitAndLoss) {
    this.specialProductClosingProfitAndLoss = specialProductClosingProfitAndLoss;
  }

  public Double getSpecialVarietyExchangeMargin() {
    return specialVarietyExchangeMargin;
  }

  public void setSpecialVarietyExchangeMargin(Double specialVarietyExchangeMargin) {
    this.specialVarietyExchangeMargin = specialVarietyExchangeMargin;
  }

  public Double getLastSpecialProductMargin() {
    return lastSpecialProductMargin;
  }

  public void setLastSpecialProductMargin(Double lastSpecialProductMargin) {
    this.lastSpecialProductMargin = lastSpecialProductMargin;
  }

  public Double getTheLastSpecialProductOccupiedTheExchangeMargin() {
    return theLastSpecialProductOccupiedTheExchangeMargin;
  }

  public void setTheLastSpecialProductOccupiedTheExchangeMargin(Double theLastSpecialProductOccupiedTheExchangeMargin) {
    this.theLastSpecialProductOccupiedTheExchangeMargin = theLastSpecialProductOccupiedTheExchangeMargin;
  }

  public String getYesterdaysExchangeRiskStatus() {
    return yesterdaysExchangeRiskStatus;
  }

  public void setYesterdaysExchangeRiskStatus(String yesterdaysExchangeRiskStatus) {
    this.yesterdaysExchangeRiskStatus = yesterdaysExchangeRiskStatus;
  }

  public Double getYesterdaysRisk() {
    return yesterdaysRisk;
  }

  public void setYesterdaysRisk(Double yesterdaysRisk) {
    this.yesterdaysRisk = yesterdaysRisk;
  }

  public Double getYesterdayExchangeRisk() {
    return yesterdayExchangeRisk;
  }

  public void setYesterdayExchangeRisk(Double yesterdayExchangeRisk) {
    this.yesterdayExchangeRisk = yesterdayExchangeRisk;
  }

  public Double getMarketValueEquity() {
    return marketValueEquity;
  }

  public void setMarketValueEquity(Double marketValueEquity) {
    this.marketValueEquity = marketValueEquity;
  }

  public Double getOptionMarketValue() {
    return optionMarketValue;
  }

  public void setOptionMarketValue(Double optionMarketValue) {
    this.optionMarketValue = optionMarketValue;
  }

  public Double getFreezeRoyalties() {
    return freezeRoyalties;
  }

  public void setFreezeRoyalties(Double freezeRoyalties) {
    this.freezeRoyalties = freezeRoyalties;
  }

  public Double getPremium() {
    return premium;
  }

  public void setPremium(Double premium) {
    this.premium = premium;
  }

  public Double getAvailableFundsReference() {
    return availableFundsReference;
  }

  public void setAvailableFundsReference(Double availableFundsReference) {
    this.availableFundsReference = availableFundsReference;
  }

  public Double getRisk2() {
    return risk2;
  }

  public void setRisk2(Double risk2) {
    this.risk2 = risk2;
  }

  public Double getExchangeRisk2() {
    return exchangeRisk2;
  }

  public void setExchangeRisk2(Double exchangeRisk2) {
    this.exchangeRisk2 = exchangeRisk2;
  }

  public Long getNumberOfOpenVariety() {
    return numberOfOpenVariety;
  }

  public void setNumberOfOpenVariety(Long numberOfOpenVariety) {
    this.numberOfOpenVariety = numberOfOpenVariety;
  }

  public Long getNumberOfOpenPositions() {
    return numberOfOpenPositions;
  }

  public void setNumberOfOpenPositions(Long numberOfOpenPositions) {
    this.numberOfOpenPositions = numberOfOpenPositions;
  }

  public Double getMargin2() {
    return margin2;
  }

  public void setMargin2(Double margin2) {
    this.margin2 = margin2;
  }

  public Double getMargin3() {
    return margin3;
  }

  public void setMargin3(Double margin3) {
    this.margin3 = margin3;
  }

  public Double getRisk3() {
    return risk3;
  }

  public void setRisk3(Double risk3) {
    this.risk3 = risk3;
  }

  public Double getFrozenAmountOfDelayedForeignExchange() {
    return frozenAmountOfDelayedForeignExchange;
  }

  public void setFrozenAmountOfDelayedForeignExchange(Double frozenAmountOfDelayedForeignExchange) {
    this.frozenAmountOfDelayedForeignExchange = frozenAmountOfDelayedForeignExchange;
  }

  public Double getRemainingExchangeQuota() {
    return remainingExchangeQuota;
  }

  public void setRemainingExchangeQuota(Double remainingExchangeQuota) {
    this.remainingExchangeQuota = remainingExchangeQuota;
  }
}
