package com.weather.forecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Main {
    public double temp;
    public double temp_min;
    public double temp_max;
    public double pressure;
    public double sea_level;
    public double grnd_level;
    public int humidity;
    public double temp_kf;
}
