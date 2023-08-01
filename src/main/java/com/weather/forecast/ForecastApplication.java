package com.weather.forecast;

import com.weather.forecast.model.Details;
import com.weather.forecast.model.ForeCast;
import com.weather.forecast.model.Sys;
import com.weather.forecast.model.TempWindPressDetails;
import com.weather.forecast.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ForecastApplication implements CommandLineRunner {

    @Autowired
    private WeatherService service;
    private static final HashMap<String, TempWindPressDetails> map = new HashMap<>();

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) throws Exception {

        SpringApplication app = new SpringApplication(ForecastApplication.class);
        app.run(args);

    }

    @Override
    public void run(String... args) throws Exception {
        findForecast();
    }

    private void findForecast() throws Exception {
        setDetails();
        while (true) {
            System.out.println("""

                    1. Get weather
                    2. Get Pressure
                    3. Get Wind Speed
                    0. Exit""");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputValue = reader.readLine();

            switch (inputValue) {
                case "1", "2", "3" -> {
                    displayWeatherDetails(inputValue);
                }
                default -> System.exit(0);
            }
        }
    }

    public void displayWeatherDetails(String inputValue) throws IOException {
        System.out.println("\n Please enter date");
        BufferedReader dateReader = new BufferedReader(new InputStreamReader(System.in));
        String inputDate = dateReader.readLine();
        Double value = getValues(inputDate, inputValue);
        System.out.println(value);
    }

    public void setDetails() throws Exception {
        ForeCast foreCastDetails = service.getService(getRestTemplate());

        for (int i = 0; i < foreCastDetails.list.size(); i++) {
            TempWindPressDetails details = new TempWindPressDetails();
            details.pressure = foreCastDetails.list.get(i).main.pressure;
            details.temp = foreCastDetails.list.get(i).main.temp;
            details.speed = foreCastDetails.list.get(i).wind.speed;
            map.put(foreCastDetails.list.get(i).dt_txt, details);
        }
    }

    public Double getValues(String date, String inputValue) {

        if (map.containsKey(date)) {
            TempWindPressDetails details = map.get(date);
            switch (inputValue) {
                case "1" -> {
                    return details.temp;
                }
                case "2" -> {
                    return details.pressure;
                }
                case "3" -> {
                    return details.speed;
                }
            }
        }
        return null;
    }
}



