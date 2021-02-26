package com.arun.demo.countryservices;

import com.arun.demo.countryservices.core.CountryService;
import com.arun.demo.countryservices.model.internal.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<Country>> getCountrieDetails() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }


}
