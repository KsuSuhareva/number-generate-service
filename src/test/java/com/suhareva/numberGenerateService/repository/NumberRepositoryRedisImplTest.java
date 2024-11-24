package com.suhareva.numberGenerateService.repository;

import com.suhareva.numberGenerateService.entity.Number;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class NumberRepositoryRedisImplTest {
    private NumberRepositoryRedisImpl numberRepositoryRedis;
    @Mock
    private RedisTemplate<String, Number> redisTemplate;
    @Mock
    private HashOperations<String, Object, Object> hashOperations;

    @Test
    public void save_shouldReturnTrue() {
        Mockito.when(redisTemplate.opsForHash()).thenReturn(hashOperations);
        Mockito.doNothing().when(hashOperations).put(anyString(), anyString(), any(Number.class));
        numberRepositoryRedis = new NumberRepositoryRedisImpl(redisTemplate);
        Assertions.assertTrue(numberRepositoryRedis.save(new Number("3503420241124")));
    }

    @Test
    public void save_shouldReturnFalse() {
        Mockito.when(redisTemplate.opsForHash()).thenReturn(hashOperations);
        Mockito.doThrow(RedisConnectionFailureException.class).when(hashOperations).put(anyString(), anyString(), any(Number.class));
        numberRepositoryRedis = new NumberRepositoryRedisImpl(redisTemplate);
        Assertions.assertFalse(numberRepositoryRedis.save(new Number("3503420241124")));
    }
}
