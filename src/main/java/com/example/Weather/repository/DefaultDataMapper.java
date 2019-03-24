package com.example.Weather.repository;

import com.example.Weather.RequestHandler;
import com.example.Weather.model.Data;
import com.example.Weather.service.DataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
@Repository
public class DefaultDataMapper implements DataMapper {
     private ObjectMapper mapper = new ObjectMapper();
     private static final String url = "https://airapi.airly.eu/v2/measurements/";
     private static final String apiKey = "UM641Ep2qlOXgMAcuVjdBfTB2jmIp4rY";

    public Data MapObject(RequestHandler requestHandler,Double latitude,Double longitude  ) {
        String airlyApiUrl = UrlCreator(latitude, longitude);
        try {
            return  mapper.readValue(requestHandler.getInputStream(airlyApiUrl,apiKey), Data.class);
        } catch (IOException e) {
            e.printStackTrace();
            return Data.builder().build();
        }
    }

    private String UrlCreator(Double latitude,Double longitude){
        return url +
                "nearest?lat=" +
                latitude +
                "&lng=" +
                longitude +
                "&maxDistanceKM=5";
    }
}
