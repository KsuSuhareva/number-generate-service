package com.suhareva.numberGenerateService.repository;

import com.suhareva.numberGenerateService.entity.Number;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
@Slf4j
public class NumberRepositoryRedisImpl implements NumberRepository {
    private static final String KEY = "NUMBER";
    private final RedisTemplate<String, Number> redisTemplate;

    @Override
    public boolean save(Number number) {
        try {
            redisTemplate.opsForHash().put(KEY, number.getNumber(), number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
