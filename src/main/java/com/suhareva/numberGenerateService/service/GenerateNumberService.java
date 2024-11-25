package com.suhareva.numberGenerateService.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.random.RandomGenerator;

@Service
@RequiredArgsConstructor
public class GenerateNumberService {
    public static final int NUMBER_LENGTH = 13;
    public static final int ORIGIN = 10000;
    public static final int BOUND = 99999;
    public static final String DATE_FORMAT = "uuuuMMdd";
    private static final RandomGenerator generator = RandomGenerator.getDefault();

    public String generate() {
        StringBuilder number = new StringBuilder(NUMBER_LENGTH);
        int numberPos = generator.nextInt(ORIGIN, BOUND);
        DateTimeFormatter dtfOutput = DateTimeFormatter.ofPattern(DATE_FORMAT, Locale.ENGLISH);
        String datePos = dtfOutput.format(LocalDate.now());
        number.append(numberPos);
        number.append(datePos);
        return number.toString();
    }
}
