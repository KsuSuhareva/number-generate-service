package com.suhareva.numberGenerateService.repository;

import com.suhareva.numberGenerateService.entity.Number;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class NumberRepositoryMapImplTest {
    @InjectMocks
    private NumberRepositoryMapImpl numberRepositoryMap;
    @Mock
    private Map<String, Number> repository;

    @Test
    public void save_shouldReturnNumber() {
        Mockito.when(repository.put(any(String.class), any(Number.class))).thenReturn(null);
        boolean result = numberRepositoryMap.save(new Number("3503420241124"));
        Assertions.assertTrue(result);
    }

    @Test
    public void save_shouldReturnNull() {
        Mockito.when(repository.put(any(String.class), any(Number.class))).thenReturn(new Number("3503420241124"));
        boolean result = numberRepositoryMap.save(new Number("3503420241124"));
        Assertions.assertFalse(result);
    }
}
