package com.example.Weather.service;

import com.example.Weather.model.Data;


public interface ForecastService {
    Double[] getForecastCAQI(Data data);
    String[] getForecastAQIColors(Data data);
}
