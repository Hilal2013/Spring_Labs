package com.cydeo.client;

import com.cydeo.dto.WeatherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url="https://weatherstack.com/",name = "WEATHER-CLIENT")
public interface WeatherClient {

    @GetMapping("/current")//from weatherstack website
    WeatherDTO getCurrentWeather(@RequestParam(value = "accessKey") String accessKey);

}
