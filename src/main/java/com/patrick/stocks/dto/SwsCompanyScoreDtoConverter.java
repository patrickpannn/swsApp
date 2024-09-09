package com.patrick.stocks.dto;

import com.patrick.stocks.entities.SwsCompanyScore;

import static java.util.Objects.isNull;

public class SwsCompanyScoreDtoConverter {

    public static SwsCompanyScoreDto convertToDto(SwsCompanyScore swsCompanyScore) {
        if (isNull(swsCompanyScore)) return SwsCompanyScoreDto.builder().build();
        return SwsCompanyScoreDto.builder()
                .dateGenerated(swsCompanyScore.getDateGenerated())
                .dividend(swsCompanyScore.getDividend())
                .future(swsCompanyScore.getFuture())
                .health(swsCompanyScore.getHealth())
                .management(swsCompanyScore.getManagement())
                .past(swsCompanyScore.getPast())
                .value(swsCompanyScore.getValue())
                .misc(swsCompanyScore.getMisc())
                .total(swsCompanyScore.getTotal())
                .sentence(swsCompanyScore.getSentence())
                .build();
    }
}
