package com.example.avners.Acitivities;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.avners.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    protected static int num1, num2,power1, power2, curScore1 ,curScore2, score1, score2, res = 0, countWins1 = 0, countWins2 = 0;
    protected static List<String> l1, l2;
    protected static String stScore, ndScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.hideMyFrame(this);
        initLists();

    }

    private void initLists() {
    if(l1 == null && l2 == null) {
        l1 = new ArrayList<>();
        l2 = new ArrayList<>();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus)
            ScreenUtils.hideMyFrame(this);
    }
    public static void addToList() {


        Log.d("SCORE1", "addToList: Score1: " + score1);
        Log.d("SCORE2", "addToList: Score2: " + score2);
        if (score1 >= 10) {
            l1.add("Win");
            l2.add("Lose");
            countWins1++;
        }  else if (score2 >= 10) {
            l1.add("Lose");
            l2.add("Win");
            countWins2++;
        }
    }
}
