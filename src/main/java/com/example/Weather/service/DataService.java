package com.example.Weather.service;

import com.example.Weather.model.Data;

public interface DataService {
    Data getData(Double latitude, Double longitude);
}
