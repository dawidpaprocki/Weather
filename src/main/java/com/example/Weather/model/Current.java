package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
@Data
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {
    private Standards[] standards;
    private Indexes[] indexes;
    private String fromDateTime;
    private Values[] values;
    private String tillDateTime;
}
