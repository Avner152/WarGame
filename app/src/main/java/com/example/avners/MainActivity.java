package com.example.avners;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String myKey = "myKey";
    private TextView main_LBL_title, main_LBL_Winner;
    private Button main_BTN_GaneStart, main_BTN_Inst, main_BTN_Quit ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        main_BTN_GaneStart.setBackgroundColor(Color.parseColor("#C0C0C0"));
        main_BTN_Inst.setBackgroundColor(Color.parseColor("#C0C0C0"));
        main_BTN_Quit.setBackgroundColor(Color.parseColor("#C0C0C0"));

        initViews();


//        if (savedInstanceState != null) {
//
//        }
    }

    private void initViews() {
        main_BTN_GaneStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, Activity_Game.class);
                startActivity(intent);
            }
        });

        main_BTN_Inst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, Instructions_Activity.class);
                startActivity(intent);
            }
        });

        main_BTN_Quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStop();
            }
        });
    }

    private void findViews() {
        main_LBL_title = findViewById(R.id.main_LBL_title);
        main_LBL_Winner = findViewById(R.id.game_LBL_Winner);
        main_BTN_GaneStart = findViewById(R.id.main_BTN_GameStart);
        main_BTN_Inst = findViewById(R.id.main_BTN_Instruction);
        main_BTN_Quit = findViewById(R.id.main_BTN_Quit);

    }

    @Override
    protected void onStart() {
        Log.d("Been Started", "Hello Now!");
        super.onStart();
    }

    @Override
    protected void onPause() {
        Log.d("Been Paused", "See You Soon...");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d("Been Killed", "Good GoodBye");
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putInt(myKey, counter);
    }

    @Override
    protected void onResume() {
        Log.d("Been Resumed", "Hey I'm Back!");
        super.onResume();
    }

}