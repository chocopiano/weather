package com.example.tiempo1.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WEATHER_TBL")
public class Weather {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(name = "lat")
    private int lat;
    @Column(name = "longitud")
    private int longitud;
    private int temp;
    private int wind;
    private int cloud;
    @Column(name = "date")
    private String date;

}
