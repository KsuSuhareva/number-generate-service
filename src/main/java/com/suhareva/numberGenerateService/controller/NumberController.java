package com.suhareva.numberGenerateService.controller;

import com.suhareva.numberGenerateService.entity.Number;
import com.suhareva.numberGenerateService.service.NumberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numbers")
@RequiredArgsConstructor
@Tag(name = "NumberService",
        description = "Контроллер для работы с номером/уникальным идентификатором")
public class NumberController {
    private final NumberService service;

    @PostMapping(value = "/generateNumber", produces = "application/json")
    @Operation(summary = "Возвращает сгенерированный номер", description = "Возвращает уникальный номер (идентификатор)")
    public ResponseEntity<Number> generateNumber() {
        return new ResponseEntity<>(service.generateNumber(), HttpStatus.OK);
    }
}
