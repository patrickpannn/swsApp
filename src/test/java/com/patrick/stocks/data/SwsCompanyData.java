package com.patrick.stocks.data;

import com.patrick.stocks.entities.SwsCompany;
import java.util.*;

import static com.patrick.stocks.data.RandomData.randomDate;
import static com.patrick.stocks.data.RandomData.randomInt;
import static com.patrick.stocks.data.SwsCompanyPricesData.createRandomTestPriceClose;

public class SwsCompanyData {
    public static SwsCompany createRandomCompany() {
        var score = SwsCompanyScoreData.createRandomTestScore();
        var company = new SwsCompany(
                UUID.randomUUID().toString(),
                "Company " + randomInt(1000),
                "TCK" + randomInt(100),
                "NYSE",
                "TCK" + randomInt(100) + ".NYSE",
                randomDate(),
                "Security Name " + randomInt(1000),
                "US",
                "USD",
                "http://company" + randomInt(1000) + ".com",
                "company-ticker-" + randomInt(1000),
                score,
                null
        );
        score.setSwsCompany(company);
        return company;
    }

    public static SwsCompany createRandomCompanyWithPrices() {
        var randomCompany = createRandomCompany();
        var priceClose1 = createRandomTestPriceClose();
        priceClose1.setSwsCompany(randomCompany);
        var priceClose2 = createRandomTestPriceClose();
        priceClose2.setSwsCompany(randomCompany);
        var priceCloseList = List.of(priceClose1, priceClose2);
        randomCompany.setSwsCompanyPriceCloseList(priceCloseList);

        return randomCompany;
    }
}


