package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;


    public AddressController(AddressService addressService) {
        this.addressService = addressService;

    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAddressList() {

        return ResponseEntity.ok(new ResponseWrapper("AddressList Retrieved", addressService.findAllAddress()));

    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerId(@PathVariable("id") Long customerId) {

        return ResponseEntity.ok(new ResponseWrapper("Addresses Retrieved", addressService.findAddressCustomerId(customerId)));

    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO address )  {


        return ResponseEntity.ok(new ResponseWrapper("Address Saved",  addressService.save(address)));
    }
@PutMapping
    public ResponseEntity<Void> updateAddress(@RequestBody AddressDTO addressDTO)  {

        addressService.update(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressListByStartsWithAddress(@PathVariable("address") String keyword) {

        return ResponseEntity.ok(new ResponseWrapper("Addresses Retrieved", addressService.findAddressStartingWith(keyword)));

    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerId(@PathVariable("customerId") Long id, @PathVariable("name") String name) {

        return ResponseEntity.ok(new ResponseWrapper("Addresses Retrieved", addressService.findAllByCustomerIdAndName(id, name)));

    }

}
