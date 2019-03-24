package com.example.Weather;

import com.example.Weather.controller.HomeController;
import com.example.Weather.model.Data;
import com.example.Weather.model.Indexes;
import com.example.Weather.model.Standards;
import com.example.Weather.model.Values;
import com.example.Weather.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests {
    @Mock
    CurrentService currentService;
    @Mock
    DataService dataService;
    @Mock
    HistoryService historyService;
    @Mock
    ForecastService forecastService;
    @Mock
    DefaultStandardsService defaultStandardsService;

    @InjectMocks
    HomeController homeController;

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(homeController)
                .build();
        currentServiceMock();
    }

    private void currentServiceMock() {
        when(dataService.getData(1.0,1.0))
                .thenReturn(Data.builder().build());
        when(currentService.getOverAllInformation(Data.builder().build()))
                .thenReturn(new Indexes[]{Indexes.builder().build()});
    }

    @Test
    public void choiceCityParamTest() throws Exception {
		mockMvc.perform(get("/choiceCity"))
				.andExpect(status().is4xxClientError());
        mockMvc.perform(get("/choiceCity?longitude=1.0&latitude=1.0&cityName=City"))
                .andExpect(status().is2xxSuccessful());
    }



    @Test
    public void contextLoads() {
    }


}
