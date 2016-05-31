package com.mdeveloper.diegoalves.cars.domain;

/**
 * Created by Diego Alves on 31/05/2016.
 */
public class Car {

    public long id;
    public String type;
    public String name;
    public String desc;
    public String urlPhoto;
    public String urlInfo;
    public String urlVideo;
    public String latitude;
    public String longitude;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
