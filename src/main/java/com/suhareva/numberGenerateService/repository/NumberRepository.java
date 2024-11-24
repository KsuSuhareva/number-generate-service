package com.suhareva.numberGenerateService.repository;

import com.suhareva.numberGenerateService.entity.Number;

public interface NumberRepository {
    boolean save(Number number);
}
