package com.patrick.stocks.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwsCompanyDto {
    private String name;
    private String tickerSymbol;
    private String exchangeSymbol;
    private String uniqueSymbol;
    private Date dateGenerated;
    private String securityName;
    private String exchangeCountryIso;
    private String listingCurrencyIso;
    private String canonicalUrl;
    private String uniqueSymbolSlug;
    private SwsCompanyScoreDto swsCompanyScore;
    private List<SwsCompanyPriceCloseDto> historicalPrices;
}
