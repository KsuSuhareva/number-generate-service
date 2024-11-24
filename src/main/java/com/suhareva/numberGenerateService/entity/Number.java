package com.suhareva.numberGenerateService.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Number")
@Schema(description = "Сгенерированный идентификатор")
public class Number implements Serializable {
    @Schema(description = "Идентификатор", example = "3503420241124")
    private String number;
}
