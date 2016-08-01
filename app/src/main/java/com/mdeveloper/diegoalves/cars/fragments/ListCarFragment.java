package com.mdeveloper.diegoalves.cars.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdeveloper.diegoalves.cars.R;
import com.mdeveloper.diegoalves.cars.activities.CarActivity;
import com.mdeveloper.diegoalves.cars.adapter.CarAdapter;
import com.mdeveloper.diegoalves.cars.domain.Car;
import com.mdeveloper.diegoalves.cars.domain.CarService;

import java.io.IOException;
import java.util.List;

/**
 * Created by Diego Alves on 31/05/2016.
 */
public class ListCarFragment extends Fragment {

    protected RecyclerView recyclerView;
    private List<Car> mCars;
    private LinearLayoutManager mLayoutManager;
    private String type;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cars, container, false);

        if (getArguments() != null) {
            this.type = getArguments().getString("type");
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskCars();

    }

    private void taskCars() {
        new GetCarsTask().execute();
    }

    private CarAdapter.CarOnClickListener onClickCar() {
        return new CarAdapter.CarOnClickListener() {
            @Override
            public void onClickCar(View view, int position) {
                Car c = mCars.get(position);
                Intent intent = new Intent(getContext(), CarActivity.class);
                intent.putExtra("car", c);
                startActivity(intent);
            }
        };
    }

    private class GetCarsTask extends AsyncTask<Void, Void, List<Car>> {

        @Override
        protected List<Car> doInBackground(Void... params) {
            try {
                return CarService.getCars(getContext(), type);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Car> cars) {
            if (cars != null) {
                ListCarFragment.this.mCars = cars;
                recyclerView.setAdapter(new CarAdapter(cars, getContext(), onClickCar()));
            }
        }
    }
}
