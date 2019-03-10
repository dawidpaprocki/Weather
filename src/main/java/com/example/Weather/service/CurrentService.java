package com.example.Weather.service;

import com.example.Weather.model.Data;
import com.example.Weather.model.Indexes;
import com.example.Weather.model.Standards;
import com.example.Weather.model.Values;

public interface CurrentService {
     Values[] getValue(Data data);

     Standards[] getWHOStandards(Data data);

     Indexes[] getOverAllInformation(Data data);

     String getTillDateTime(Data data);

     String getFromDateTime(Data data);
}
