package com.mdeveloper.diegoalves.cars.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdeveloper.diegoalves.cars.R;
import com.mdeveloper.diegoalves.cars.domain.Car;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarFragment extends Fragment {

    private Car mCar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car, container, false);
        return view;
    }

    public void setCar(Car car) {
        if (car != null) {
            mCar = car;
            TextView textView = (TextView) getView().findViewById(R.id.textDescription);
            textView.setText(mCar.desc);
            ImageView imageView = (ImageView) getView().findViewById(R.id.img);
            Picasso.with(getContext()).load(mCar.urlPhoto).into(imageView);
        }
    }

}
