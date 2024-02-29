package com.eazybytes.accounts.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

// the object in this class can be read through getter but there is no setter method in
// this class so people can only read info and no one can change it
@ConfigurationProperties(prefix = "accounts")
// bind with application/yml. make sure prefix is right
// also this is a bean so it is made when app starts
public record AccountsContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
    // java will make those fields final and create only getter methods behind the scene

}
