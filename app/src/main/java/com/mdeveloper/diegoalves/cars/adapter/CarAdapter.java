package com.mdeveloper.diegoalves.cars.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mdeveloper.diegoalves.cars.R;
import com.mdeveloper.diegoalves.cars.domain.Car;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Diego Alves on 31/05/2016.
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarsViewHolder> {

    private List<Car> mCars;
    private Context mContext;
    private CarOnClickListener mCarOnClickListener;

    public CarAdapter(List<Car> cars, Context context, CarOnClickListener carOnClickListener) {
        this.mCars = cars;
        this.mContext = context;
        this.mCarOnClickListener = carOnClickListener;
    }

    public interface CarOnClickListener {
        void onClickCar(View view, int position);
    }

    @Override
    public CarsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_car, parent, false);
        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CarsViewHolder holder, final int position) {
        Car c = mCars.get(position);
        holder.tvName.setText(c.name);
        holder.progressBar.setVisibility(View.VISIBLE);

        Picasso.with(mContext).load(c.urlPhoto).into(holder.ivImage, new Callback() {
            @Override
            public void onSuccess() {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
                holder.progressBar.setVisibility(View.GONE);
            }
        });

        if(mCarOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCarOnClickListener.onClickCar(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mCars.size();
    }

    public class CarsViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public ImageView ivImage;
        public ProgressBar progressBar;
        public CardView cardView;

        public CarsViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.text);
            ivImage = (ImageView) itemView.findViewById(R.id.img);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressImg);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

        }
    }

}
