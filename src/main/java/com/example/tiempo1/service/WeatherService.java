package com.example.tiempo1.service;

import com.example.tiempo1.entity.Weather;
import com.example.tiempo1.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.format.DateTimeFormatter;
import java.time.*;
@Service
public class WeatherService {
    @Autowired
    private WeatherRepository repository;

    public Weather saveWeather(Weather weather) {
        return repository.save(weather);
    }

    public List<Weather> saveWeathers(List<Weather> weathers) {
        List<Weather> lista = repository.saveAll(weathers);
        return lista;
    }

    public List<Weather> getWeathers() {
        return repository.findAll();
    }

    public List<Weather> getWeatherRectangule(int lat1, int lat2, int longitud1, int longitud2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);
        return repository.findByLatGreaterThanEqualAndLatLessThanEqualAndLongitudGreaterThanEqualAndLongitudLessThanEqualAndDate(lat1, lat2, longitud1, longitud2, date);
    }

    public Weather getWeatherById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Weather getWeatherByName(String name) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);
        return repository.findByNameAndDate(name, date);
    }
}