package com.example.Weather.service;

import com.example.Weather.model.Data;


public interface HistoryService {
    Double[] getHistoricalCAQI(Data data);
    String[] getHistoricalCAQIColors(Data data);
}
