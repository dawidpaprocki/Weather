package com.example.Weather.mappers;

import com.example.Weather.RequestHandler;
import com.example.Weather.model.Data;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DataMapper {
     private ObjectMapper mapper = new ObjectMapper();

    public Data MapObject(RequestHandler requestHandler) throws IOException {
       Data data;
       return data = mapper.readValue(requestHandler.getInputStream(
                "https://airapi.airly.eu/v2/measurements/nearest?lat=50.062006&lng=19.940984&maxDistanceKM=5",
                "UM641Ep2qlOXgMAcuVjdBfTB2jmIp4rY"), Data.class);

    }
}
