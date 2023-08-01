package com.weather.forecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Details {
    public int dt;
    public Main main;
    public ArrayList<Weather> weather;
    public Clouds clouds;
    public Wind wind;
    public Sys sys;
    public String dt_txt;
}
