package com.example.Weather.repository;

import com.example.Weather.RequestHandler;
import com.example.Weather.model.Data;
import org.springframework.stereotype.Component;

@Component
public interface DataMapper {
    Data MapObject(RequestHandler requestHandler, Double latitude, Double longitude);
}
