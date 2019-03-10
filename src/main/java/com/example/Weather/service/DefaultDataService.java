package com.example.Weather.service;

import com.example.Weather.RequestHandler;
import com.example.Weather.model.Data;
import com.example.Weather.repository.DefaultDataMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultDataService implements DataService {
    private DefaultDataMapper defaultDataMapper;

    public DefaultDataService(DefaultDataMapper defaultDataMapper) {
        this.defaultDataMapper = defaultDataMapper;
    }

    public Data getData(Double latitude, Double longitude) {
        return defaultDataMapper.MapObject(new RequestHandler(), latitude, longitude);
    }
}
