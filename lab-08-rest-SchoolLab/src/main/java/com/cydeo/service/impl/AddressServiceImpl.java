package com.cydeo.service.impl;

import com.cydeo.client.CountryClient;
import com.cydeo.client.WeatherClient;
import com.cydeo.dto.AddressDTO;
import com.cydeo.entity.Address;
import com.cydeo.repository.AddressRepository;
import com.cydeo.service.AddressService;
import com.cydeo.util.MapperUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final WeatherClient weatherClient;
    private final CountryClient countryClient;
    @Value("${access_key}")
    private String access_key;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, WeatherClient weatherClient, CountryClient countryClient) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.weatherClient = weatherClient;
        this.countryClient = countryClient;
    }

    @Override
    public List<AddressDTO> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO findById(Long id) throws Exception {
        Address foundAddress = addressRepository.findById(id)
                .orElseThrow(() -> new Exception("No Address Found!"));
        AddressDTO addressDTO = mapperUtil.convert(foundAddress, new AddressDTO());
        addressDTO.setCurrentTemperatureC(retrieveCurrentWeather(addressDTO.getCity()));
        addressDTO.setCurrentTemperatureF(((retrieveCurrentWeather(addressDTO.getCity())*9)/5)+32);

        //we will get the flag link based on the country
        addressDTO.setFlag(retrieveFlagByCountry(addressDTO.getCountry()));
        return addressDTO;

    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) throws Exception {

        addressRepository.findById(addressDTO.getId())
                .orElseThrow(() -> new Exception("No Address Found!"));

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        return mapperUtil.convert(addressToSave, new AddressDTO());

    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) throws Exception {

        Optional<Address> foundAddress = addressRepository.findById(addressDTO.getId());

        if (foundAddress.isPresent()) {
            throw new Exception("Address Already Exists!");
        }

        Address addressToSave = mapperUtil.convert(addressDTO, new Address());

        addressRepository.save(addressToSave);

        return mapperUtil.convert(addressToSave, new AddressDTO());

    }
    private Integer retrieveCurrentWeather(String city){

       return weatherClient.getCurrentWeather(access_key,city).getCurrent().getTemperature();

    }
    private String retrieveFlagByCountry(String countryName){

       return countryClient.getCountryInfo(countryName).get(0).getFlags().getPng();

    }
}