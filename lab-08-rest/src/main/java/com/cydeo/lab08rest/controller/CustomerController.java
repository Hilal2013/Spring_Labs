package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    private final CustomerService customerService;
@GetMapping
    public ResponseEntity<ResponseWrapper> getCustomerList(){
    return ResponseEntity.ok(new ResponseWrapper("CustomerList Retrieved", customerService.findAllCustomers(), HttpStatus.OK));

    }
@GetMapping("/{email}")
    public  ResponseEntity<ResponseWrapper> getCustomerListByEmail(@PathVariable("email") String email){

    return ResponseEntity.ok(new ResponseWrapper("Customer Retrieved", customerService.findCustomerEmail(email), HttpStatus.OK));

    }

@PostMapping
    public  ResponseEntity<ResponseWrapper> createCustomer(@RequestBody CustomerDTO customer){

    return ResponseEntity.ok(new ResponseWrapper("Customer Saved",  customerService.save(customer), HttpStatus.OK));

    }

    @PutMapping
    public  ResponseEntity<Void> updateCustomer(@RequestBody CustomerDTO customer)  {
customerService.update(customer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
