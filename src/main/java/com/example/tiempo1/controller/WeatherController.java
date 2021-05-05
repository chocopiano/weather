package com.example.tiempo1.controller;
import java.time.format.DateTimeFormatter;
import java.time.*;

import com.example.tiempo1.entity.Weather;
import com.example.tiempo1.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
class JsonHolder {
    private List<AllBody> list;
    private String cod;
    private String calctime;
    private String cnt;

    public List<AllBody> getList() {
        return list;
    }

}
@JsonIgnoreProperties(ignoreUnknown = true)
class AllBody {
    private int id;
    private int dt;
    private String name;
    private Coord coord;
    private Main main;
    private int visibility;
    private Wind wind;
    private float rain;
    private float snow;
    private Clouds clouds;
    private List<Time> weather;

    public Wind getWind(){
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Main getMain() {
        return main;
    }
    public String getName() {
        return name;
    }
    public Coord getCoord(){
        return coord;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Time {
    private int id;
    private String main;
    private String description;
    private String icon;
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Clouds {
    private int today;
    private int all;

    public int getAll(){
        return all;
    }

    public int getToday(){
        return today;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Wind {
    private float speed;
    private float deg;

    public float getSpeed(){
        return speed;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Main {
    private float temp;
    private float feels_like;
    private float temp_min;
    private float temp_max;
    private float pressure;
    private float humidity;

    public float getTemp(){
        return temp;
    }
}
@JsonIgnoreProperties(ignoreUnknown = true)
class Coord {
    private float Lon;
    private float Lat;
    private float lon;
    private float lat;

    public float getLon(){
        return Lon;
    }
    public float getLat(){
        return Lat;
    }
}

@RestController
public class WeatherController {

    @Autowired
    private WeatherRepository repository;

    @GetMapping("/weathers/{lat1}/{lat2}/{longitud1}/{longitud2}")
    public List<Weather> findAllWeatherRectangule(@PathVariable String lat1, @PathVariable String lat2, @PathVariable String longitud1, @PathVariable String longitud2) {
        List<Weather> array = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.openweathermap.org/data/2.5/box/city?bbox=" +lat1+","+lat2+","+longitud1+","+longitud2+","+"10&appid=5cfb049c2fdfdfa9a38cd0496a148faf";
            ResponseEntity<JsonHolder> result = restTemplate.getForEntity(url,JsonHolder.class);
            for (AllBody i : result.getBody().getList()) {
                System.out.println(i.getName());
                Weather w = new Weather();
                w.setName(i.getName());
                w.setTemp(i.getMain().getTemp());
                w.setWind(i.getWind().getSpeed());
                w.setCloud(i.getClouds().getToday());
                w.setDate(date);
                repository.save(w);
                array.add(w);
            }
            return array;
        }
        catch(Exception e) {
            Weather w = new Weather();
            w.setDate(date);
            repository.save(w);
            array.add(w);
            return array;
        }
    }

    @GetMapping("/weather/{name}")
    public Weather findWeatherByName(@PathVariable String name) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + name + "&appid=5cfb049c2fdfdfa9a38cd0496a148faf";
            ResponseEntity<AllBody> result = restTemplate.getForEntity(url, AllBody.class);
            Weather w = new Weather();
            w.setName(result.getBody().getName());
            w.setTemp(result.getBody().getMain().getTemp());
            w.setWind(result.getBody().getWind().getSpeed());
            w.setCloud(result.getBody().getClouds().getAll());
            w.setDate(date);
            repository.save(w);
            return w;
        }
        catch(Exception e){
            Weather w = new Weather();
            w.setDate(date);
            repository.save(w);
            return w;
        }
    }
}