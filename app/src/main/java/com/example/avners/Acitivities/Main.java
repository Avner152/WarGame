package com.example.avners.Acitivities;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.avners.utils.Score;
import com.example.avners.utils.ScreenUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    protected  int num1, num2, power1, power2, score1, curScore1, curScore2, score2, res = 0, countWins1, countWins2;
    protected  List<String> l1, l2;
    protected  String stScore, ndScore;
    protected  Score s1, s2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.hideMyFrame(this);
        Gson gson = new Gson();
        String jStr1 = gson.toJson(l1);
        String jStr2 = gson.toJson(l2);

        inits();
            Log.d("sttt", "inits!");
    }


    private void inits() {
        if(l1 == null && l2 == null) {
            l1 = new ArrayList<>();
            l2 = new ArrayList<>();
        }
        if(s1 == null && s2 == null) {
            s1 = new Score();
            s2 = new Score();
        }
        if(stScore == null && ndScore == null)
        stScore = ndScore = "";
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
            ScreenUtils.hideMyFrame(this);
    }

}