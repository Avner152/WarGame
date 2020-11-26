package com.example.avners;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Instructions_Activity extends AppCompatActivity {

    private Handler handler = new Handler();
    private String[] strs = new String[9];
    private String newStr = "";
    private static final int DELAY = 40;
    private TextView tv;
    private char[][] ch = new char[9][92];
    private int row = 0, col = 0, countForSpace = 0;


    Runnable r = new Runnable() {

        @Override
        public void run() {
            try {
                newStr += ch[row][col++];
                tv.setText(newStr);
                if(col == strs[row].length()){
                    newStr+= "\n";
                    row++;
                    col = 0;
                }
                if (row < 2)
                    handler.postDelayed(r, 80);
                else if(row <= 9 )
                    handler.postDelayed(r, 40);

                else{
                    stopDelay();
                }
            }
            catch (Exception e){

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_);
        tv = findViewById(R.id.R_id_TEXT);
        printStr();
        int num = findMyLength();
        startDelay();


    }

    private int findMyLength() {
        int sum = 0;
        for (int i = 0; i < 9; i ++)
            sum += strs[i].length();
        return sum;
    }


    private void startDelay() {
        handler.postDelayed(r, DELAY);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    private void printStr() {
        strs[0] = "Greeting, Summoners!";
        strs[1] = "Welcome the our War! so here's some rules:";
        strs[2] = "1) The game starts when both participant's score initiated with 0.";
        strs[3] = "2) In Order to take the next step, the user has to click 'DEAL'.";
        strs[4] = "3) The participant with the greater power level wins +1 score! the other stays the same.";
        strs[5] = "4) When it's a tie then both participants losing 1 point.";
        strs[6] = "5) When it's a tie and any participant has 0 points then they stay the same.";
        strs[7] = "6) The first participant that gets to 10 points is the Winner! Congrants !!";
        strs[8] = "HAVE FUN!";

        for (int i = 0; i < 9; i++)
            strToChar(strs[i], i);
    }



    private void stopDelay() {
        handler.removeCallbacks(r);

    }

    private void strToChar(String str, int index) {
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i)+"").isEmpty())
                ch[index][i] = ' ';
            ch[index][i] = str.charAt(i);
        }
    }
}