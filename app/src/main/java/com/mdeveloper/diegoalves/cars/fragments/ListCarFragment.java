package com.mdeveloper.diegoalves.cars.fragments;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mdeveloper.diegoalves.cars.R;
import com.mdeveloper.diegoalves.cars.activities.CarActivity;
import com.mdeveloper.diegoalves.cars.adapter.CarAdapter;
import com.mdeveloper.diegoalves.cars.domain.Car;
import com.mdeveloper.diegoalves.cars.domain.CarService;
import com.mdeveloper.diegoalves.cars.util.Connection;

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
    private SwipeRefreshLayout refreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cars, container, false);

        if (getArguments() != null) {
            this.type = getArguments().getString("type");
        }

        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeToRefresh);
        refreshLayout.setOnRefreshListener(OnRefreshListener());

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        return view;
    }

    private SwipeRefreshLayout.OnRefreshListener OnRefreshListener() {
        return new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(Connection.isNetworkAvailable(getContext())) {
                    taskCars();
                } else {
                    Toast.makeText(getContext(), "Sem conexão", Toast.LENGTH_SHORT).show();
                    refreshLayout.setRefreshing(false);
                }

            }
        };
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //taskCars();

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
                refreshLayout.setRefreshing(false);
                recyclerView.setAdapter(new CarAdapter(cars, getContext(), onClickCar()));
            }
        }
    }
}
