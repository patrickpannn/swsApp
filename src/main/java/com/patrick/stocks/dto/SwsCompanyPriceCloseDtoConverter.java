package com.patrick.stocks.dto;

import com.patrick.stocks.entities.SwsCompanyPriceClose;

import static java.util.Objects.isNull;

public class SwsCompanyPriceCloseDtoConverter {
    public static SwsCompanyPriceCloseDto convertToDto(SwsCompanyPriceClose swsCompanyPriceClose) {
        if (isNull(swsCompanyPriceClose)) return SwsCompanyPriceCloseDto.builder().build();
        return SwsCompanyPriceCloseDto.builder()
                .date(swsCompanyPriceClose.getId().getDate())
                .price(swsCompanyPriceClose.getPrice())
                .dateCreated(swsCompanyPriceClose.getDateCreated())
                .build();
    }
}
