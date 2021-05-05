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
@Table(name = "OPEN_WEATHER")
public class Weather {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private float temp;
    private float wind;
    private float cloud;
    @Column(name = "date")
    private String date;

    public void setName(String name){
        this.name = name;
    }

    public void setTemp(float temp){
        this.temp = temp;
    }
    public void setWind(float wind){
        this.wind = wind;
    }
    public void setCloud(float cloud){
        this.cloud = cloud;
    }
    public void setDate(String date){
        this.date = date;
    }

}
