package com.example.Weather.service;

import com.example.Weather.RequestHandler;
import com.example.Weather.model.Cities;
import com.example.Weather.model.Data;
import com.example.Weather.repository.CitiesMapperFormFile;
import com.example.Weather.repository.DataMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultDataService implements DataService {
    private DataMapper dataMapper;
    private CitiesMapperFormFile citiesMapperFormFile;

    public DefaultDataService(DataMapper dataMapper, CitiesMapperFormFile citiesMapperFormFile) {
        this.dataMapper = dataMapper;
        this.citiesMapperFormFile = citiesMapperFormFile;
    }

    public Data getData(Double latitude, Double longitude) {
        Data data = dataMapper.MapObject(new RequestHandler(), latitude, longitude);
        return data;
    }

    @Override
    public Cities[] getDataFromFile() {
        return citiesMapperFormFile.GetCities();
    }
}
