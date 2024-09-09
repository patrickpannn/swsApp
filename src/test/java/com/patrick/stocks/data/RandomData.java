package com.patrick.stocks.data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomData {
    public static Date randomDate() {
        var minDay = LocalDate.of(2000, 1, 1).toEpochDay();
        var maxDay = LocalDate.of(2023, 12, 31).toEpochDay();
        var randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return Date.from(LocalDate.ofEpochDay(randomDay).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String randomDateString() {
        var randomDate = LocalDate.now().minusDays(new Random().nextInt(3650));
        return randomDate.toString();
    }

    public static int randomInt(int bound) {
        var random = new Random();
        return random.nextInt(bound);
    }
}
