package com.cydeo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url="https://weatherstack.com/",name = "WEATHER-CLIENT")
public interface WeatherClient {

   // @GetMapping("")
  //  WeatherDTO

}
