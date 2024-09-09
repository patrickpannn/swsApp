package com.patrick.stocks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwsCompanyScoreDto {
    private Date dateGenerated;
    private int dividend;
    private int future;
    private int health;
    private int management;
    private int past;
    private int value;
    private int misc;
    private int total;
    private String sentence;
}
