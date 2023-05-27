package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public AddressDTO findAddressCustomerIdAndName(Long id, String name) {
       return mapperUtil.convert(addressRepository.findAllByCustomerIdAndName(id,name),new AddressDTO());
//        return addressRepository.findAllByCustomerIdAndName(id, name).stream()
//                .map(entity -> mapperUtil.convert(entity, new AddressDTO()))
//                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findAddressStartingWith(String keyword) {


       return addressRepository.findAllByStreetStartingWith(keyword).stream()
                .map(entity -> mapperUtil.convert(entity, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) throws Exception {
        Optional<Address> foundAddress = addressRepository.findById(addressDTO.getId());

        if (foundAddress.isPresent()) {
            throw new Exception("Address Already Exists!");
        }
        addressRepository.save(mapperUtil.convert(addressDTO, new Address()));
        return addressDTO;
    }

    @Override
    public void update(AddressDTO addressDTO) throws Exception {

        addressRepository.findById(addressDTO.getId())
                  .orElseThrow(() -> new Exception("No Address Found!"));

        Address address = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(address);

    }


}
