package com.suhareva.numberGenerateService.repository;

import com.suhareva.numberGenerateService.entity.Number;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Primary
@Repository
@RequiredArgsConstructor
@Slf4j
public class NumberRepositoryRedisImpl implements NumberRepository {
    private static final String KEY = "NUMBER";
    private final RedisTemplate redisTemplate;

    @Override
    public boolean save(Number number) {
        try {
            redisTemplate.opsForHash().put(KEY, number.getNumber(), number);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
