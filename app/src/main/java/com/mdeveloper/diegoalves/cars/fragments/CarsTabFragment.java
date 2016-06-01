package com.mdeveloper.diegoalves.cars.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdeveloper.diegoalves.cars.R;
import com.mdeveloper.diegoalves.cars.adapter.TabsAdapter;

/**
 * Created by Diego Alves on 01/06/2016.
 */
public class CarsTabFragment extends Fragment implements TabLayout.OnTabSelectedListener {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tab_cars, container, false);

        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(new TabsAdapter(getContext(), getChildFragmentManager()));

        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        int color = ContextCompat.getColor(getContext(), R.color.white);
        mTabLayout.setTabTextColors(color, color);

        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.classics));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.sports));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.lux));

        // handler clicks on tabs
        mTabLayout.setOnTabSelectedListener(this);
        // handler update tab selected
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        return view;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        // alter tab update viewPager
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
