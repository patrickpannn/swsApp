package com.patrick.stocks.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwsCompanyPriceCloseDto {
    private String date;
    private float price;
    private LocalDateTime dateCreated = LocalDateTime.now();
}
