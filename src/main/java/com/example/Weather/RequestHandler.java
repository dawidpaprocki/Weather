package com.example.Weather;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestHandler {


    public InputStream getInputStream(String userUrl, String apiKey) throws IOException {
        return createConnection(userUrl,apiKey).getInputStream();
    }

    private HttpURLConnection createConnection(String userUrl, String apiKey) throws IOException {
        URL url = new URL(userUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("apikey", apiKey);

        return connection;
    }

}