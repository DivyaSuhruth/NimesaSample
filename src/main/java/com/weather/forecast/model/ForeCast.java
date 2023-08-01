package com.weather.forecast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForeCast {

    public String cod;
    public double message;
    public int cnt;
    public ArrayList<Details> list;
    public City city;
}


