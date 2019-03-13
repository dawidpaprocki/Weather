package com.example.Weather.service;

import com.example.Weather.model.Data;

import java.util.List;


public interface HistoryService {
    Double[] getHistoricalCAQI(Data data);
    String[] getHistoricalCAQIColors(Data data);
}
