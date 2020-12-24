package com.example.avners.Acitivities;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.avners.R;
import com.example.avners.fragments.Fragment_list;
import com.example.avners.fragments.Fragment_map;

import java.util.ArrayList;

public class Scores_Activity extends Main implements Fragment_list.CallBack_list {

    protected static TextView TXT_score1, TXT_score2, LBL_Total_Wins1, LBL_Total_Wins2;
    private ImageView score_IMG_wp;
    private Fragment_list fragment_list = new Fragment_list();

    private Fragment_map fragment_map;
    private ListView listView;
    private ArrayList<String> myList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);
        findViews();
        String str = "abc";

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
        ft.add(R.id.score_LAY_list, fragment_list).commit();

        fragment_map = new Fragment_map();
        getSupportFragmentManager().beginTransaction().add(R.id.score_LAY_map, fragment_map).commit();

//        technicalThingsToDo();
//        printWins();

    }

    private void listFragManager() {

        fragment_list.setCallBackList(this);

    }

    private void technicalThingsToDo() {
        LBL_Total_Wins1.setText(countWins1 + "");
        LBL_Total_Wins2.setText(countWins2 + "");
    }


    private void findViews() {
        listView = findViewById(R.id.score_list);
//        score_IMG_wp = findViewById(R.id.score_IMG_wp);
    }
    @Override
    protected void onStart() {
        super.onStart();


    }

    protected  void printWins() {
        Log.d("pttt", "list1 size: " + l1.size() + " | list2 size " + l2.size());
        Log.d("pttt", "countWins1: " + countWins1 + " | countWins2: " + countWins2);
    if(countWins1 + countWins2 == 10) {
        stScore = "";
        ndScore = "";
    }

        for (int i = 0; i < l1.size(); i++) {
            Log.d("ptt", "printWins: " + l1.size() + ", " + l1.get(i));
                stScore += l1.get(i) + "\n\n";
                ndScore += l2.get(i) + "\n\n";
            }
            stScore = TXT_score1.getText() + stScore;
            ndScore = TXT_score2.getText() + ndScore;
            l1.clear();
            l2.clear();

        TXT_score1.setText(stScore + "\n");
        TXT_score2.setText(ndScore + "\n");

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
        Log.i("yoni: ", "onScoreSampleListener: " + d1 + " , " + d2);
        fragment_map.setCoord(d1, d2);
    }

    @Override
    public void addWinnerToList(String str) {

    }
}