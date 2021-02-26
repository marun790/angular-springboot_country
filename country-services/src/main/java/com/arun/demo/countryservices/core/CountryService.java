package com.arun.demo.countryservices.core;

import com.arun.demo.countryservices.CountriesProxy;
import com.arun.demo.countryservices.model.external.CountryInfo;
import com.arun.demo.countryservices.model.internal.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountriesProxy countriesProxy;

    public List<Country> getAllCountries() {
        return countriesProxy.getAllCountryDetails()
                .stream()
                .map(this::transformToCountries)
                .collect(Collectors.toList());
    }


    private Country transformToCountries(CountryInfo countryInfo) {
        Country country = null;
        if (countryInfo != null) {
            country = new Country();
            country.setName(countryInfo.getName());
            country.setAlpha2Code(countryInfo.getAlpha2Code());
            country.setCapital(countryInfo.getCapital());
            country.setPopulation(countryInfo.getPopulation());
            country.setFlag(countryInfo.getFlag());
        }
        return country;
    }

}
