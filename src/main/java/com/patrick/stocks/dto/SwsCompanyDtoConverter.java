package com.patrick.stocks.dto;

import com.patrick.stocks.entities.SwsCompany;

import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class SwsCompanyDtoConverter {
    public static SwsCompanyDto convertToDto(SwsCompany swsCompany, boolean includePrices) {
        if (isNull(swsCompany)) return SwsCompanyDto.builder().build();
        var companyBuilder = SwsCompanyDto.builder()
                .name(swsCompany.getName())
                .tickerSymbol(swsCompany.getTickerSymbol())
                .exchangeSymbol(swsCompany.getExchangeSymbol())
                .uniqueSymbol(swsCompany.getUniqueSymbol())
                .dateGenerated(swsCompany.getDateGenerated())
                .securityName(swsCompany.getSecurityName())
                .exchangeCountryIso(swsCompany.getExchangeCountryIso())
                .listingCurrencyIso(swsCompany.getListingCurrencyIso())
                .canonicalUrl(swsCompany.getCanonicalUrl())
                .uniqueSymbolSlug(swsCompany.getUniqueSymbolSlug())
                .swsCompanyScore(SwsCompanyScoreDtoConverter.convertToDto(swsCompany.getSwsCompanyScore()));
        if (includePrices && nonNull(swsCompany.getSwsCompanyPriceCloseList())) {
            companyBuilder.historicalPrices(swsCompany.getSwsCompanyPriceCloseList().stream().map(SwsCompanyPriceCloseDtoConverter::convertToDto).collect(Collectors.toList()));
        }
        return companyBuilder.build();
    }
}
