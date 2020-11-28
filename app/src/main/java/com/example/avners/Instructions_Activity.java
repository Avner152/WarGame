package com.example.avners;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

public class Instructions_Activity extends AppCompatActivity {

    private final String INSTR_STR = strId();
    private Handler handler = new Handler();
    private String newStr = "";
    private static final int DELAY = 40;
    private TextView tv;
    private int n = 0;
    private MediaPlayer mp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("instr.", "Been Created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_);
        tv = findViewById(R.id.R_id_TEXT);
        playSounds(R.raw.snd_kboard);
        startDelay();
    }

    private void playSounds(int rawId) {
        mp = MediaPlayer.create(this, R.raw.snd_kboard);
        mp.start();

    }

    Runnable r = new  Runnable() {
        @Override
        public void run() {
            newStr += INSTR_STR.charAt(n++);
            tv.setText(newStr);
            if(n < 71)
                handler.postDelayed(r, 50);
            else if(n < INSTR_STR.length())
                handler.postDelayed(r, 25);

             if(n == INSTR_STR.length())
                mp.stop();
        }
    };


    private String strId() {
     return "Greeting, Summoners!\n" +
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
        Log.d("instr.", "Been Started");
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();
    }

    private void stopDelay() {
        Log.d("instr.", "Been Stopped ");
        mp.stop();
        handler.removeCallbacks(r);
    }
}