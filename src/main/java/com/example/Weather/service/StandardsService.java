package com.example.Weather.service;

import com.example.Weather.model.Data;

public interface StandardsService {
   String getCurrentStandardName(Data data,String pollutantName);
   Double getCurrentStandardPercent(Data data, String pollutantName);

}
