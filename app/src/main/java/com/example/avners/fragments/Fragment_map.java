package com.example.avners.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.avners.R;

public class Fragment_map extends Fragment {

    private TextView tv_title;
    private View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.map_fragment, container, false);
        return v;
    }

    public void setCoord(double d1, double d2){
       tv_title =  v.findViewById(R.id.title_TXT);
       tv_title.setText(d1 + " , " +  d2);
    }

}
