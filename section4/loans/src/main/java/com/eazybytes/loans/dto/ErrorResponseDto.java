package com.eazybytes.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "error Response"
)
@Data
@AllArgsConstructor
public class ErrorResponseDto {
    @Schema(
            description = "API path invoked by client"
    )
    private String apiPath;
    @Schema(
            description = "code indicating error type"
    )
    private HttpStatus errorCode;
    @Schema(
            description = "message describing error"
    )
    private String errorMessage;

    @Schema(
            description = "when the error occurs"
    )
    private LocalDateTime errorTime;

}