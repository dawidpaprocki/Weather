package com.example.Weather.service;

import com.example.Weather.model.Data;
import com.example.Weather.model.Indexes;

public interface StandardsService {
   String getStandardPollutantName(Data data, String pollutantName);
   Double getStandardPercent(Data data, String pollutantName);

}
