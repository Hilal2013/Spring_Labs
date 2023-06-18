package com.cydeo.lab08rest.client;


import com.cydeo.lab08rest.dto.currency.CurrencyApiResponse;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(url = "http://apilayer.net/api",name = "currencyApiClient")
public interface CurrencyApiClient {

    @GetMapping("/live")
    Map<String,Object> getCurrentCurrency(@RequestParam(value = "access_key") String accessKey,
                           @RequestParam(value = "currencies") String currencies,
                                          @RequestParam(value = "source") String source,
                                          @RequestParam(value = "format") int format);

}
//,@RequestParam(value = "source") String source,@RequestParam(value = "format") int format