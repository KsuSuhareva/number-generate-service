package com.suhareva.numberGenerateService.service;

import com.suhareva.numberGenerateService.entity.Number;
import com.suhareva.numberGenerateService.handler.exception.DaoException;
import com.suhareva.numberGenerateService.repository.NumberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class NumberServiceImplTest {
    @InjectMocks
    private NumberServiceImpl numberServiceImpl;
    @Mock
    private GenerateNumberService generateNumberService;
    @Mock
    private NumberRepository repository;

    @Test
    public void generateNumber_shouldReturnNumber() {
        Mockito.when(generateNumberService.generate()).thenReturn("2568620241124");
        Mockito.when(repository.save(any(Number.class))).thenReturn(true);
        assertEquals(13, numberServiceImpl.generateNumber().getNumber().length());
    }

    @Test
    public void generateNumber_throwDaoException() {
        Mockito.when(generateNumberService.generate()).thenReturn("2568620241124");
        Mockito.when(repository.save(any(Number.class))).thenReturn(false);
        Assertions.assertThrows(DaoException.class, () -> numberServiceImpl.generateNumber());
    }
}
