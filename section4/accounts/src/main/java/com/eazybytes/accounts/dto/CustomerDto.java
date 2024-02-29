package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema holding customer info such as name, email, and mobile number"
)
public class CustomerDto {
    @Schema(
            description = "name of the customer",
            example = "sihong"
    )
    @NotEmpty(message = "name should not be null or empty")
    @Size(min = 5, max = 30, message = "size of name should be between 5 and 30")
    private String name;

    @Schema(
            description = "email of the customer",
            example = "sihong@duello.edu"
    )
    @NotEmpty(message = "email should not be null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;


    @Schema(
            description = "phone number of the customer",
            example = "1234567890"
    )
    @NotEmpty(message = "mobile number should not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "account detail of the customer"
    )
    private AccountsDto accountsDto;
}
