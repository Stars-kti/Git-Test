package com.citic.common.util.rating;

public class RatingUtils {
    /**
     * 筛选品种ID，返回确定格式
     *
     * @param prodId
     * @return
     */
    public static String getProdId(String prodId) {
        try {
            String s = prodId.split("\\.")[1];
            if ("shf".equalsIgnoreCase(s) ||
                    "ine".equalsIgnoreCase(s) ||
                    "dce".equalsIgnoreCase(s)) {
                return s.toLowerCase();
            } else {
                return s.toUpperCase();
            }
        } catch (NullPointerException e) {
            return "";
        }
    }

    /**
     * 筛选交易所ID，返回确定格式
     *
     * @param exchangeId
     * @return
     */
    public static String getExchangeId(String exchangeId) {
        try {
            String s = exchangeId.split("\\.")[1];
            if ("DCE".equalsIgnoreCase(s) ||
                    "INE".equalsIgnoreCase(s)) {
                return s.toUpperCase();
            } else if ("CZC".equalsIgnoreCase(s)) {
                return "CZCE";
            } else if ("CFF".equalsIgnoreCase(s)) {
                return "CFFEX";
            } else if ("SHF".equalsIgnoreCase(s)) {
                return "SHFE";
            } else {
                return s.toUpperCase();
            }
        } catch (NullPointerException e) {
            return "";
        }
    }
}
