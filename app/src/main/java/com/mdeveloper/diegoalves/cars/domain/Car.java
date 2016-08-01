package com.mdeveloper.diegoalves.cars.domain;

import java.io.Serializable;

/**
 * Created by Diego Alves on 31/05/2016.
 */
public class Car implements Serializable{

    public long id;
    public String type;
    public String name;
    public String desc;
    public String urlPhoto;
    public String urlInfo;
    public String urlVideo;
    public String latitude;
    public String longitude;

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
