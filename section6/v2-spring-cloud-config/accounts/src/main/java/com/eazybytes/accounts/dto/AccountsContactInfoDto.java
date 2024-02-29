package com.eazybytes.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

// the object in this class can be read through getter but there is no setter method in
// this class so people can only read info and no one can change it
@ConfigurationProperties(prefix = "accounts")
@Getter
@Setter
// bind with application/yml. make sure prefix is right
// also this is a bean so it is made when app starts

// it is possible that property values might changfe in run time in that case do not use record use class
public class AccountsContactInfoDto {
    // java will make those fields final and create only getter methods behind the scene
    private String message;
    private Map<String, String> contactDetails;
    private List<String> onCallSupport;
}
