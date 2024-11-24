package com.suhareva.numberGenerateService.handler;

import com.suhareva.numberGenerateService.handler.exception.DaoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public class GenerateServiceExceptionHandler {
    @ExceptionHandler(DaoException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessage> catchDaoException(DaoException e) {
        log.error("Catch DaoException with cause:{} ", Arrays.toString(e.getStackTrace()));
        return new ResponseEntity<>(new ErrorMessage(e), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RedisConnectionFailureException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessage> catchException(RedisConnectionFailureException e) {
        log.error("Catch redisConnectionFailureException with cause:{} ", Arrays.toString(e.getStackTrace()));
        return new ResponseEntity<>(new ErrorMessage(e), INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorMessage> catchException(Exception e) {
        log.error("Catch {} with cause:{} ", e.getClass().getSimpleName(), Arrays.toString(e.getStackTrace()));
        return new ResponseEntity<>(new ErrorMessage(e), INTERNAL_SERVER_ERROR);
    }
}
