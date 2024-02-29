package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
@Schema(
        name = "Account",
        description = "Schema holding customer account info"
)
public class AccountsDto {

    @Schema(
            name = "account number of bank account"
    )
    @NotEmpty(message = "account number should not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "account number must be 10 digits")
    private Long accountNumber;

    @Schema(
            name = "Type of account, either savings or current"
    )
    @NotEmpty(message = "account type cannot be null or empty")
    private String accountType;

    @Schema(
            name = "Bank branch address"
    )
    @NotEmpty(message = "branch address type cannot be null or empty")
    private String branchAddress;
}
