package com.example.avners;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Main {

    private TextView main_LBL_title, main_LBL_Winner;
    private Button main_BTN_GaneStart, main_BTN_Inst, main_BTN_Quit, main_BTN_Scores ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("main", "Been Created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
