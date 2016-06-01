package com.mdeveloper.diegoalves.cars.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mdeveloper.diegoalves.cars.R;
import com.mdeveloper.diegoalves.cars.fragments.CarFragment;

/**
 * Created by Diego Alves on 01/06/2016.
 */
public class TabsAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public TabsAdapter(Context context, FragmentManager manager) {
        super(manager);
        this.mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        if(position == 0) {
            args.putString("type", "classics");
        } else if(position == 1) {
            args.putString("type", "sports");
        } else {
            args.putString("type", "lux");
        }
        Fragment f = new CarFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return mContext.getString(R.string.classics);
        } else if(position == 1) {
            return mContext.getString(R.string.classics);
        }
        return mContext.getString(R.string.lux);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
