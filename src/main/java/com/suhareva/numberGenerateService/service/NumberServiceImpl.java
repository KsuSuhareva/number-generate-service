package com.suhareva.numberGenerateService.service;

import com.suhareva.numberGenerateService.entity.Number;
import com.suhareva.numberGenerateService.handler.exception.DaoException;
import com.suhareva.numberGenerateService.repository.NumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NumberServiceImpl implements NumberService {
    private final NumberRepository repository;

    @Override
    public Number generateNumber() {
        Number number = new Number(GenerateNumberService.generate());
        if (!repository.save(number)) {
            throw new DaoException("Number not save");
        }
        return number;
    }
}
