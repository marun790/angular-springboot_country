package com.arun.demo.countryservices.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country
{

    private String name;

    @JsonProperty("country_code")
    private String alpha2Code;

    private String capital;

    private Long population;

    @JsonProperty("flag_file_url")
    private String flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
