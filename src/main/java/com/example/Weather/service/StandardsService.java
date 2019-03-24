package com.example.Weather.service;

import com.example.Weather.model.Data;
import com.example.Weather.model.Indexes;

public interface StandardsService {
   String getCurrentStandardName(Data data,String pollutantName);
   Double getCurrentStandardPercent(Data data, String pollutantName);

}
