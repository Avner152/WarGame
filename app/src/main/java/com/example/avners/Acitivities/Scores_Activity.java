package com.example.avners.Acitivities;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.avners.R;
import com.example.avners.fragments.Fragment_list;
import com.example.avners.fragments.Fragment_map;
import com.google.android.gms.maps.GoogleMap;

import java.util.ArrayList;

public class Scores_Activity extends Main implements Fragment_list.CallBack_list {

    private Fragment_list fragment_list = new Fragment_list();
    private Fragment_map fragment_map;
    private ListView listView;
    private ArrayList<String> myList = new ArrayList<>();
    private String str;
    private double d1, d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        findViews();
//        Glide.with(this).load(R.drawable.wpnew).into(score_IMG_wp);
        // get the data from the previous intend
        // create new bundle
        // link bundle to fragment
        Bundle bundle = new Bundle();
        fragment_list.setArguments(bundle);
        listFragManager();

        //  MAP //
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.score_LAY_list, fragment_list).commit();

        fragment_map = new Fragment_map();
        getSupportFragmentManager().beginTransaction().add(R.id.score_LAY_map, fragment_map).commit();
    }

    private void listFragManager() {
        fragment_list.setCallBackList(this);
    }

    private void findViews() {
        listView = findViewById(R.id.score_list);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        Log.d("DESROYSCORES", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    public void onScoreSampleListener(double d1, double d2) {
        fragment_map.setCoord(d1, d2);
    }

}