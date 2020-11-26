package com.example.avners;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Instructions_Activity extends AppCompatActivity {

    private Handler handler = new Handler();
    private String newStr = "", str;
    private static final int DELAY = 40;
    private TextView tv;
    private int n = 0;

    Runnable r = new Runnable() {

        @Override
        public void run() {
                newStr += str.charAt(n++);
                tv.setText(newStr);
                if(n < 71)
                    handler.postDelayed(r, 50);
                else if(n < str.length())
                    handler.postDelayed(r, 25);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_);
        tv = findViewById(R.id.R_id_TEXT);
        printMyStr();
        startDelay();
    }

    private void printMyStr() {
     str = "Greeting, Summoners!\n" +
            "Welcome to our War! So here are some rules:\n\n" +
            "1) The game starts when both participant's score initiated with Zero.\n\n" +
            "2) In Order to take the next step, the user has to click 'DEAL'.\n\n" +
            "3) The participant with the greater power level gains +1 to his score! the other stays the same.\n\n" +
            "4) When it's a tie then both participants losing 1 point.\n\n" +
            "5) When it's a tie and any participant has Zero points then they stay the same.\n\n" +
            "6) The first participant that gets to Ten points is the Winner! Congrants !!\n\n\n" +
            "And Most Important --> Have Fun!!!";
    }


    private void startDelay() {
        handler.postDelayed(r, DELAY);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    private void stopDelay() {
        handler.removeCallbacks(r);
    }
}