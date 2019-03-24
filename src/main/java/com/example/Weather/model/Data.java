package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
@lombok.Data
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private Current current;
    private History[] history;
    private Forecast[] forecast;

}
