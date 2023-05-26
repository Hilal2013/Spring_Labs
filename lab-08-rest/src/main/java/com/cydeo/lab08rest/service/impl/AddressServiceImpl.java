package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AddressDTO> findAllAddress() {

        return addressRepository.findAll().stream()
                .map(entity -> mapperUtil.convert(entity, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findAddressCustomerId(Long id) {
        return addressRepository.retrieveByCustomerId(id).stream()
                .map(entity -> mapperUtil.convert(entity, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findAddressCustomerAndName(Long id, String name) {
        return addressRepository.findAllByCustomerIdAndName(id, name).stream()
                .map(entity -> mapperUtil.convert(entity, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findAddressStartingWith(String keyword) {
        return addressRepository.findAllByStreetStartingWith(keyword).stream()
                .map(entity -> mapperUtil.convert(entity, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO save(AddressDTO address) {
        addressRepository.save(mapperUtil.convert(address, new Address()));
        return address;
    }

    @Override
    public void update(AddressDTO addressDTO) {
        Address address = mapperUtil.convert(addressDTO, new Address());
        address.setName(address.getName());
        addressRepository.save(address);
    }


}
