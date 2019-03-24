package com.example.Weather.Enums;

public enum DataResponse {
    LACKOFDATA("Lack of Data");


    private final String text;
    DataResponse(String text) {
        this.text= text;
    }

    @Override
    public String toString() {
        return text;
    }
}
