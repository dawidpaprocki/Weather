package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Standards {
    private String name;
    private String limit;
    private String percent;
    private String pollutant;
}
