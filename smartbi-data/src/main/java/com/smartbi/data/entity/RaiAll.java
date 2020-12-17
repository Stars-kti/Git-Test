package com.smartbi.data.entity;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class RaiAll {


    private Integer id;
    private Timestamp tradingDay;
    private Double rat;
    private Double ibRat;
    private Double legalPersonRat;
    private String code;
    private String name;
    private String level;

    public RaiAll() {
    }

    public RaiAll(Timestamp tradingDay, Double rat, Double ibRat, Double legalPersonRat, String code, String name, String level) {
        this.tradingDay = tradingDay;
        this.rat = rat;
        this.ibRat = ibRat;
        this.legalPersonRat = legalPersonRat;
        this.code = code;
        this.name = name;
        this.level = level;
    }

}
