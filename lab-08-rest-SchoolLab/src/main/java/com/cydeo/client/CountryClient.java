package com.cydeo.client;


import com.cydeo.dto.WeatherDTO;
import com.cydeo.dto.country.CountryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(url="https://restcountries.com",name = "COUNTRY-CLIENT")
public interface CountryClient {
    //    https://restcountries.com/v3.1/name/Finland
    @GetMapping("/v3.1/name/{countryName}")
    List<CountryDTO> getCountryInfo(@PathVariable(value = "countryName") String countryName);


}
