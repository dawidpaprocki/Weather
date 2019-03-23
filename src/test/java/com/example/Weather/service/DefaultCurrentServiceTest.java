package com.example.Weather.service;

import com.example.Weather.model.Current;
import com.example.Weather.model.Data;
import com.example.Weather.model.Values;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class DefaultCurrentServiceTest {

    @Mock
    Data data;
    @Mock
    Current current;

    @InjectMocks
    DefaultCurrentService defaultCurrentService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getValueTest() {
        // Given
        Values values = new Values();
        values.setName("testValue");
        Values[] values1 = new Values[]{values};
        // When
        when(data.getCurrent())
                .thenReturn(current);
        when(current.getValues())
                .thenReturn(values1);
        String valueName = defaultCurrentService.getValue(data)[0].getName();
        // Then
        assertEquals("testValue",valueName);
    }

    @Test
    public void getWHOStandards() {
        fail();
    }

    @Test
    public void getOverAllInformation() {
        fail();
    }

    @Test
    public void getTillDateTime() {
        fail();
    }

    @Test
    public void getFromDateTime() {
        fail();
    }
}