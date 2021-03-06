package com.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.R;
import com.app.adapter.ChildOfLocationInfoFragment;
import com.app.view.LocationDetailActivity;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;


public class LocationInfoFragment extends Fragment{
    private int location_id;
    private LocationDetailActivity activity;

    public static LocationInfoFragment newInstance(int location_id, LocationDetailActivity activity) {
        return new LocationInfoFragment(location_id, activity);
    }

    public LocationInfoFragment(int location_id, LocationDetailActivity activity){
        this.location_id = location_id;
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycle_view, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        //setup materialviewpager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);
        ChildOfLocationInfoFragment adapter = new ChildOfLocationInfoFragment(getContext(), location_id, activity);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(adapter);
    }
}