package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.CustomerRepository;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final MapperUtil mapperUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        return customerRepository.findAll().stream()
                .map(entity -> mapperUtil.convert(entity, new CustomerDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findCustomerEmail(String email) {

        return mapperUtil.convert(customerRepository.retrieveByCustomerEmail(email),new CustomerDTO());
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
    customerRepository.save(mapperUtil.convert(customerDTO,new Customer()));
        return customerDTO ;
    }

    @Override
    public void update(CustomerDTO customerDTO)  {
        Customer customer = mapperUtil.convert(customerDTO, new Customer());
        customerRepository.findById(customer.getId())
                .ifPresent(renewCustomer->{renewCustomer.setFirstName(customer.getFirstName());
                    renewCustomer.setLastName(customer.getLastName());
                    renewCustomer.setUserName(customer.getUserName());
                    renewCustomer.setEmail(customer.getEmail());
                    renewCustomer.setAddressList(customer.getAddressList());

                    customerRepository.save(renewCustomer);
                });



    }

    @Override
    public Boolean existById(Long customerId) {

            return customerRepository.existsById(customerId);

    }
}
