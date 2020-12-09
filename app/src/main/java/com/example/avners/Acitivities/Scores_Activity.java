package com.example.avners.Acitivities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.avners.R;

import java.util.ArrayList;
import java.util.List;

public class Scores_Activity extends Main {

    protected TextView TXT_score1, TXT_score2, LBL_Total_Wins1, LBL_Total_Wins2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        findViews();
        technicalThingsToDo();
        printWins();

    }

    private void technicalThingsToDo() {
        LBL_Total_Wins1.setText(countWins1 + "");
        LBL_Total_Wins2.setText(countWins2 + "");


    }


    private void findViews() {
        LBL_Total_Wins1 = findViewById(R.id.LBL_Total_Wins1);
        LBL_Total_Wins2 = findViewById(R.id.LBL_Total_Wins2);
        TXT_score1 = findViewById(R.id.TXT_Scores1);
        TXT_score2 = findViewById(R.id.TXT_Scores2);
    }
    @Override
    protected void onStart() {
        super.onStart();
        score1 = score2 = 0;
        LBL_Total_Wins1.setText(countWins1 + "");
        LBL_Total_Wins2.setText(countWins2 + "");

    }

    private void printWins() {
        if(stScore== null && ndScore == null)
            stScore = ndScore = "";
    if(countWins1 + countWins2 == 10) {
        stScore = "";
        ndScore = "";
    }
        for (int i = 0; i < l1.size(); i++) {
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
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        Log.d("DESROYSCORES", "onDestroy: ");
        super.onDestroy();
    }
}