package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;

// we have I in class name because we have implementation in this class
public interface IAccountsService {

    /**
     *
     * @param customerDto - CustomerDto object carrying customer input data to construct customer object with
     */
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);

}
