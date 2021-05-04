package com.example.tiempo1.controller;

import com.example.tiempo1.entity.Weather;
import com.example.tiempo1.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService service;

    @PostMapping("/addWeather")
    public Weather addWeather(@RequestBody Weather weather) {
        return service.saveWeather(weather);
    }

    @PostMapping("/addWeathers")
    public List<Weather> addWeathers(@RequestBody List<Weather> weathers) {
        return service.saveWeathers(weathers);
    }

    @GetMapping("/weathers")
    public List<Weather> findAllWeathers() {
        return service.getWeathers();
    }
    @GetMapping("/weathers/{lat1}/{lat2}/{longitud1}/{longitud2}")
    public List<Weather> findAllWeatherRectangule(@PathVariable int lat1, @PathVariable int lat2, @PathVariable int longitud1, @PathVariable int longitud2) {
        return service.getWeatherss(lat1, lat2, longitud1, longitud2);
    }

    @GetMapping("/weatherById/{id}")
    public Weather findWeatherById(@PathVariable int id) {
        return service.getWeatherById(id);
    }

    @GetMapping("/weather/{name}")
    public Weather findWeatherByName(@PathVariable String name) {
        return service.getWeatherByName(name);
    }
}