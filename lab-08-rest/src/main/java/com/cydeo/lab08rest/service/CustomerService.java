package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {


    List<CustomerDTO> findAllCustomers();
    CustomerDTO findCustomerEmail(String email);

    CustomerDTO save(CustomerDTO customer);
    void update(CustomerDTO customer);
}
