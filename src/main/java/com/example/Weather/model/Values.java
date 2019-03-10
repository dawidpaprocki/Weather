package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.aspectj.lang.annotation.DeclareAnnotation;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Values {
    private String name;
    private String value;
}
