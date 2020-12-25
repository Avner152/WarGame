package com.example.avners.fragments;

import android.graphics.Camera;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.avners.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Fragment_map extends Fragment{

    private TextView tv_title;
    private View v;
    private double lant, lont;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.map_fragment, container, false);

        Bundle b = new Bundle();
        lant = b.getDouble("lant",18);
        lont = b.getDouble("lont", 12);
        // init my map //
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_Map);

        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(LatLng latLng) {
                        MarkerOptions markerOptions = new MarkerOptions();
                        // sets position of marker //
                        markerOptions.position(latLng);
                        // set title of marker //
                        markerOptions.title(latLng.latitude + " : " + latLng.longitude);
                        // remove all markers //
                        googleMap.clear();
                        // Animating to zoom the marker //
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));

                        // add marker on map //
                        googleMap.addMarker(markerOptions);

                    }
                });
            }
        });
        return v;
    }

    public void setCoord(double d1, double d2){
        tv_title =  v.findViewById(R.id.title_TXT);
        tv_title.setText(d1 + " , " +  d2);
    }

}
