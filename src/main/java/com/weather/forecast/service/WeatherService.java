package com.weather.forecast.service;

import com.weather.forecast.model.ForeCast;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherService {


    public  ForeCast getService(RestTemplate restTemplate) throws Exception {
        return restTemplate.getForObject(
                "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22", ForeCast.class);
    }

}
