package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;

import java.util.List;

public interface AddressService {
List<AddressDTO> findAllAddress();
    List<AddressDTO> findAddressCustomerId(Long id);
    AddressDTO findAddressCustomerIdAndName(Long id,String name);
    List<AddressDTO> findAddressStartingWith(String keyword);
    AddressDTO save(AddressDTO address) throws Exception;
    void update(AddressDTO address) throws Exception;
}
