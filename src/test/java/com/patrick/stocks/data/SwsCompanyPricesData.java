package com.patrick.stocks.data;

import com.patrick.stocks.entities.SwsCompanyPriceClose;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

import static com.patrick.stocks.data.RandomData.randomDateString;

public class SwsCompanyPricesData {
    public static SwsCompanyPriceClose createRandomTestPriceClose() {
        var random = new Random();
        var priceCloseId =
                new SwsCompanyPriceClose.SwsCompanyPriceCloseId(
                        randomDateString(),
                        UUID.randomUUID().toString()
                );

        return new SwsCompanyPriceClose(
                priceCloseId,
                null,
                random.nextFloat() * 1000, // Random price
                LocalDateTime.now()
        );
    }
}
