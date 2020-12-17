package com.smartbi.data.entity;

import lombok.Data;
import java.sql.Timestamp;

/**
 * @author chenjiaxing
 */
@Data
public class RightsAndInterests {


    private Integer id;
    private Timestamp tradingDay;
    private Double rat;
    private Double ibRat;
    private Double legalPersonRat;


}
