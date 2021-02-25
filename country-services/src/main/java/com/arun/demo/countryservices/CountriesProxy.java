package com.arun.demo.countryservices;

import com.arun.demo.countryservices.model.external.CountryInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface CountriesProxy {

    @GetMapping(value = "/rest/v2/all")
    List<CountryInfo> getAllCountryDetails();

}
