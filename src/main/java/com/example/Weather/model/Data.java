package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import java.util.List;
@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private Current current;
    private History[] history;
    private Forecast[] forecast;

}
