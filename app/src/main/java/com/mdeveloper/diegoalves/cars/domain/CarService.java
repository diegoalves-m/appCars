package com.mdeveloper.diegoalves.cars.domain;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego Alves on 31/05/2016.
 */
public class CarService {

    public static List<Car> getCars(Context context) {
        List<Car> cars = new ArrayList<>();

        for(int i = 0; i < 20; i++) {
            Car c = new Car();
            c.name = "Car "+ i;
            c.desc = "Desc "+ i;
            c.urlPhoto = "http://res.cloudinary.com/sayaryx/image/upload/v1464700468/carro_i6ghan.png";
            cars.add(c);
        }
        return cars;
    }

}
