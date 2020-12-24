package com.example.avners.Acitivities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.avners.R;

public class Instructions_Activity extends Main {

    private static final int TIME_INTERVAL = 10000;
    private long mBackPressed;
    private final String INSTR_STR = strId();
    private Handler handler = new Handler();
    private String newStr = "";
    private static final int DELAY = 750;
    private TextView tv;
    private Button inst_BTN_back, inst_BTN_skip;
    private int curChar = 0;
    private MediaPlayer mp;
    private ImageView inst_IMG_wp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("instr.", "Been Created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_);
        initViewsForInst();
        ViewBottons();
        Glide.with(this).load(R.drawable.wpnew).into(inst_IMG_wp);

        startDelay();
    }


    private void ViewBottons() {
        inst_BTN_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBackPressed = System.currentTimeMillis();
                Log.d("pres time", "onClick: " + mBackPressed);
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                    Log.d("pres time", "onClick: " + mBackPressed + TIME_INTERVAL);
                    Log.d("pres time", "onClick: " + System.currentTimeMillis());


                    stopDelay();
                    finish();
                }
            }
        });
        inst_BTN_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(INSTR_STR);
                stopDelay();
            }
        });
    }

    private void initViewsForInst() {

        inst_IMG_wp = findViewById(R.id.inst_IMG_wp);
        tv = findViewById(R.id.R_id_TEXT);
        inst_BTN_skip = findViewById(R.id.inst_BTN_skip);
        inst_BTN_back = findViewById(R.id.inst_BTN_back);
    }

    private void playSounds(int rawId) {
        mp = MediaPlayer.create(this, R.raw.snd_kboard);
        mp.start();
    }

    Runnable r = new Runnable() {
        @Override
        public void run() {
            printMyStr(++curChar);
        }
    };

    private void printMyStr(int curChar) {
        newStr += INSTR_STR.charAt(curChar);

        if (curChar < 70)
            handler.postDelayed(r, 80);
        else if (curChar < INSTR_STR.length() - 1) {
            handler.postDelayed(r, 60);
            if (!mp.isPlaying())
                mp.start();
        } else if (curChar == INSTR_STR.length() - 1)
            stopDelay();
        tv.setText(newStr);

    }

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
        printMyStr(curChar);
        playSounds(R.raw.snd_kboard);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.stop();
        stopDelay();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void stopDelay() {
        Log.d("instr.", "Been Stopped ");
        mp.stop();
        handler.removeCallbacks(r);
    }

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL < System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Tap back button in order to exit", Toast.LENGTH_SHORT).show();
        }

        mBackPressed = System.currentTimeMillis();
    }

}