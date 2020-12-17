package com.citic.common.util.excel;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class MarketUtils {

    private static final String FUND_INQUIRY_KEY = "{'投资者代码':'investorCode','经纪公司代码':'brokerageCompanyCode','风险状态':'riskStatus'," +
            "'风险度':'risk','投资者帐号':'investorAccount','交易所风险状态':'exchangeRiskStatus','交易所风险度':'exchangeRisk'," +
            "'交易所可用资金':'availableFundsOnTheExchange','上次质押':'lastPledge','上次资金冻结':'lastFundsFreeze','昨结存':'yesterdayBalance'," +
            "'昨权益':'yesterdayRights','上次占用保证金':'lastOccupiedMargin','出入金':'depositAndWithdrawal','保证金':'securityDeposit'," +
            "'手续费':'handlingFee','平仓盈亏':'closingProfitAndLoss','持仓盈亏':'positionProfitAndLoss','权益':'rightsAndInterests'," +
            "'可用资金':'availableFunds','质押金额':'pledgeAmount','交易所保证金':'exchangeMargin','保底资金':'guaranteedFund','可取资金':'availableFundsOut'," +
            "'资金冻结':'fundFreeze','投资者名称':'investorName','昨风险状态':'yesterdaysRiskStatus','强平标志':'liquidationSign'," +
            "'昨强平标志':'yesterdayLiquidationSign','历史强平次数':'historicalLiquidations','风险持仓':'riskPosition','上次交易所保证金':'lastExchangeMargin'," +
            "'通知状态':'notificationStatus','组织架构代码':'organizationCode','组织架构名称':'organizationStructureName','特殊标志':'specialSign'," +
            "'交割保证金':'deliveryMargin','交易所交割保证金':'exchangeDeliveryMargin','保证金冻结':'marginFreeze','手续费冻结':'freezeFee'," +
            "'电话通知标志':'phoneNotificationSign','币种':'currency','上次质入':'lastPledgePut','上次质出':'lastQualityOut','质入金额':'pledgeAmountPut'," +
            "'质出金额':'pledgeAmountOut','质押余额':'pledgeBalance','可质押金额':'pledgeableDeposit','特殊产品保证金':'specialProductMargin'," +
            "'特殊产品保证金冻结':'specialProductMarginFreeze','特殊产品手续费':'specialProductHandlingFee','特殊产品手续费冻结':'specialProductFeeFreeze'," +
            "'特殊产品持仓盈亏':'specialProductHoldingProfitAndLoss','特殊产品平仓盈亏':'specialProductClosingProfitAndLoss'," +
            "'特殊品种交易所保证金':'specialVarietyExchangeMargin','上次特殊产品保证金':'lastSpecialProductMargin'," +
            "'上次特殊产品占用交易所保证金':'theLastSpecialProductOccupiedTheExchangeMargin','昨交易所风险状态':'yesterdaysExchangeRiskStatus'," +
            "'昨风险度':'yesterdaysRisk','昨交易所风险度':'yesterdayExchangeRisk','市值权益':'marketValueEquity','期权市值':'optionMarketValue'," +
            "'冻结权利金':'freezeRoyalties','权利金':'premium','可用资金参考':'availableFundsReference','风险度2':'risk2'," +
            "'交易所风险度2':'exchangeRisk2','持仓品种数量':'numberOfOpenVariety','持仓合约数量':'numberOfOpenPositions'," +
            "'保证金2':'margin2','保证金3':'margin3','风险度3':'risk3','延时换汇冻结金额':'frozenAmountOfDelayedForeignExchange'," +
            "'剩余换汇额度':'remainingExchangeQuota'}";



    private static final String POSITION_KEY = "{'投资者代码':'investorCode','合约':'contract','总买持':'totalBuy'," +
        "'总卖持':'totalHold','交易所保证金':'exchangeMargin','实收交易所保证金':'realTimeExchangeMargin','今买持':'buyNow'," +
        "'买可平':'buyCanFlat','买均价':'averagePurchasePrice','买冻结':'buyFreeze','买保证金':'buyMargin','买开仓均价':'averageOpenPrice'," +
        "'今卖持':'imamatsu','卖可平':'sellCanFlat','卖均价':'averageSellingPrice','卖冻结':'sellFreeze','卖保证金':'sellMargin'," +
        "'卖开仓均价':'averagePositionPrice','平仓盈亏':'closingProfitAndLoss','手续费':'handlingFee','保证金':'securityDeposit'," +
        "'昨结算':'settlementYesterday','投保':'insure','交易日':'tradingDay','交易所':'exchange','风险度':'risk'," +
        "'投资者名称':'investorName','特殊标志':'specialSign','品种':'variety','交割期':'deliveryPeriod','组织架构代码':'organizationCode'," +
        "'组织架构名称':'organizationStructureName','币种':'currency','经纪公司代码':'brokerageCompanyCode','实收买保证金':'actualPurchaseMargin'," +
        "'实收卖保证金':'realMargin','实收保证金':'paidMargin','执行冻结':'executionFreeze','放弃执行冻结':'waiveExecutionFreeze'," +
        "'卖权利金':'sellRoyalty','买权利金':'buyRoyalties','执行冻结金额':'performFrozenAmount','实收买保证金占比':'percentageOfActualPurchaseMargin'," +
        "'实收卖保证金占比':'percentageOfActualSalesMargin','希腊值Delta':'greekValueDelta','分时结算价':'timeSharePrice'," +
        "'TAS总买持':'tasTotalBuyAndHold','最新价':'latestPrice','实虚值额':'realAndVirtualValue','持仓盈亏':'positionProfitAndLoss'," +
        "'TAS总卖持':'tasAlwaysSold','多头期权市值':'marketValueOfLongOptions','空头期权市值':'marketValueOfShortOptions'}";

    private static final String RISK_CONTROL_MARKET_KEY = "{'合约':'contract','最新价':'latestPrice','成交量':'volume','成交额':'turnover'," +
            "'持仓量':'openInterest','昨结算':'settlementYesterday','昨收盘':'closedYesterday','昨持仓':'positionYesterday'," +
            "'今开盘':'openToday','最高价':'highestPrice','最低价':'floorPrice','今收盘':'closeToday','今结算':'settlementToday'," +
            "'涨停价':'priceLimit','跌停价':'limitPrice','买价':'buyingPrice','买量':'purchaseAmount','卖价':'sellingPrice'," +
            "'卖量':'salesVolume','均价':'averagePrice','涨跌':'upsAndDowns'}";

    public static Map getKey(Integer id){
        if (id == 0) {
            return JSONObject.parseObject(FUND_INQUIRY_KEY, Map.class);
        } else if (id == 1) {
            return JSONObject.parseObject(POSITION_KEY, Map.class);
        } else {
            return JSONObject.parseObject(RISK_CONTROL_MARKET_KEY, Map.class);
        }
    }
}
