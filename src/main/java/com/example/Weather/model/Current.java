package com.example.Weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {
    private String fromDateTime;
    private String tillDateTime;

    public String getFromDateTime ()
    {
        return fromDateTime;
    }

    public void setFromDateTime (String fromDateTime)
    {
        this.fromDateTime = fromDateTime;
    }


    public String getTillDateTime ()
    {
        return tillDateTime;
    }

    public void setTillDateTime (String tillDateTime)
    {
        this.tillDateTime = tillDateTime;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [standards = , fromDateTime = "+fromDateTime+", tillDateTime = "+tillDateTime+"]";
    }
}
