package com.suhareva.numberGenerateService.handler;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Schema(description = "Сообщение об ошибке")
public class ErrorMessage {
    @Schema(description = "Название ошибки", example = "DaoException")
    private String errorName;
    @Schema(description = "Сообщение ошибки", example = "Number not save")
    private String errorMessage;
    @Schema(description = "Дата возникновения ошибки", example = "2024-11-18T16:56:43.053+00:00")
    private Date date;

    public ErrorMessage(Exception exception) {
        this.errorName = exception.getClass().getSimpleName();
        this.errorMessage = exception.getMessage();
        this.date = new Date();
    }
}
