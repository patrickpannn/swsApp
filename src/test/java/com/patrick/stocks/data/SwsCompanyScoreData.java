package com.patrick.stocks.data;

import com.patrick.stocks.entities.SwsCompanyScore;
import org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;
import java.util.Random;

public class SwsCompanyScoreData {
    public static SwsCompanyScore createRandomTestScore() {
        var random = new Random();
        return new SwsCompanyScore(
                random.nextInt(1000),
                null,
                new Date(),
                random.nextInt(100), // dividend
                random.nextInt(100), // future
                random.nextInt(100), // health
                random.nextInt(100), // management
                random.nextInt(100), // past
                random.nextInt(100), // value
                random.nextInt(100), // misc
                random.nextInt(600), // total
                RandomStringUtils.randomAlphabetic(10)
        );
    }
}
