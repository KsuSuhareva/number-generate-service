package com.suhareva.numberGenerateService.repository;

import com.suhareva.numberGenerateService.entity.Number;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Primary
@Repository
@RequiredArgsConstructor
public class NumberRepositoryMapImpl implements NumberRepository {
    private Map<String, Number> orderNumbers = new HashMap<>();

    @Override
    public boolean save(Number number) {
        return orderNumbers.put(number.getNumber(), number) == null;
    }

}
