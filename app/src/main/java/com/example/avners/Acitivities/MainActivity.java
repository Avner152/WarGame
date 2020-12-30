package com.example.avners.Acitivities;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.avners.R;

public class MainActivity extends Main {

    private TextView main_LBL_title, main_LBL_Winner;
    private Button main_BTN_GaneStart, main_BTN_Inst, main_BTN_Quit, main_BTN_Scores ;
    private ImageView main_IMG_background;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d("main", "Been Created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create background with Glade //
        main_IMG_background = findViewById(R.id.main_IMG_background);
        Glide.with(this).load(R.drawable.wp_main).into(main_IMG_background);

        pref = getSharedPreferences("AvnersDB", MODE_PRIVATE);
        editor = pref.edit();

        // get previous wins from editor /
        countWins1 = pref.getInt("score1", 0);
        countWins2 = pref.getInt("score2", 0);

        Log.d("Score 1 :", "stttafter action: " + countWins1 + " " + pref.getInt("score1", 0) );
        Log.d("Score 2 :", "stttafter action: " + countWins2 + " " + pref.getInt("score2", 0) );

        findViews();
        initViews();
        colorMyBtns();
    }


    private void initViews() {
        main_BTN_GaneStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, Activity_Game.class);
                startActivity(intent);
            }
        });

        main_BTN_Inst.setOnClickListener(v -> {
            Intent intent = new Intent (MainActivity.this, Instructions_Activity.class);
            startActivity(intent);
        });

        main_BTN_Quit.setOnClickListener(v -> onStop());

        main_BTN_Scores.setOnClickListener(v -> {

            Intent intent = new Intent (MainActivity.this, Scores_Activity.class);
//            intent.putExtra("avber");
            startActivity(intent);
        });
    }

    private void findViews() {
        main_LBL_title = findViewById(R.id.main_LBL_title);
        main_LBL_Winner = findViewById(R.id.game_LBL_Winner);
        main_BTN_GaneStart = findViewById(R.id.main_BTN_GameStart);
        main_BTN_Inst = findViewById(R.id.main_BTN_Instruction);
        main_BTN_Quit = findViewById(R.id.main_BTN_Quit);
        main_BTN_Scores = findViewById(R.id.main_BTN_Scores);
    }

    @Override
    protected void onStart() {
        Log.d("main", "Been Started");
        super.onStart();

        editor.putInt("score1", countWins1);
        editor.putInt("score2", countWins2);
        editor.apply();
    }

    @Override
    protected void onPause() {
        Log.d("main", "Been Paused");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d("main", "Been Destroyed");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        Log.d("main", "Been Resumed");
        super.onResume();
    }

    private void colorMyBtns() {
        main_BTN_GaneStart.setBackgroundColor(Color.parseColor("#232F34"));
        main_BTN_Inst.setBackgroundColor(Color.parseColor("#232F34"));
        main_BTN_Quit.setBackgroundColor(Color.parseColor("#232F34"));
        main_BTN_Scores.setBackgroundColor(Color.parseColor("#232F34"));
    }
}