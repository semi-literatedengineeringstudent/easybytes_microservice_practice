package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "response",
        description = "response from api call"
)
public class ResponseDto {
    @Schema(
            description = "response status code"
    )
    private String statusCode;

    @Schema(
            description = "response status message"
    )
    private String statusMsg;

}
