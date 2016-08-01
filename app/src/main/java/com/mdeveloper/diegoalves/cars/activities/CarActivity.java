package com.mdeveloper.diegoalves.cars.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.mdeveloper.diegoalves.cars.R;
import com.mdeveloper.diegoalves.cars.domain.Car;
import com.mdeveloper.diegoalves.cars.fragments.CarFragment;

public class CarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        CarFragment carFragment = (CarFragment) getSupportFragmentManager()
                .findFragmentById(R.id.carFragment);
        Car car = (Car) getIntent().getSerializableExtra("car");
            carFragment.setCar(car);

    }
}
