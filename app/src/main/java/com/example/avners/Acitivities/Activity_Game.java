package com.example.avners.Acitivities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.avners.R;
import com.example.avners.utils.Card;
import com.example.avners.utils.MyDataBase;
import com.example.avners.utils.MySPV;
import com.example.avners.utils.Record;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Activity_Game extends Main {

    public static final String KEY_DATABASE = "myKey";
    private static ArrayList<Card> cards = new ArrayList<>();
    private String winnerName, jsonInString;
    private int winnerScore;
    final int DELAY = 750;
    private TextView game_LBL_Num1, game_LBL_Num2, game_LBL_Answer, game_LBL_Winner;
    private ImageView game_IMG_LeftCard, game_IMG_RightCard, game_IMG_wp;
    private Button  game_BTN_forfeit;
    private MediaPlayer mp;
    private MyDataBase dataBase;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("game", "Game Created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__game);
        findViews();
        Glide.with(this).load(R.drawable.wpnew).into(game_IMG_wp);
        if(dataBase == null)
            dataBase = new MyDataBase();

        gson = new Gson();
        createCards();
        initViews();
    }

    private void startGame() {
        handler.postDelayed(r,DELAY);
        score1 = score2 = 0;
    }

    private void createCards() {
        cards.add(new Card(0,15, "Trunks & Goten"));
        cards.add(new Card(1,40, "Uzaro"));
        cards.add(new Card(2,15, "Bardock"));
        cards.add(new Card(3,10, "Cell"));
        cards.add(new Card(4,12, "Piccolo"));
        cards.add(new Card(5,20, "Goku"));
        cards.add(new Card(6,20, "Goku ssj3"));
        cards.add(new Card(7,14, "Vegeta ssj4"));
        cards.add(new Card(8,20, "Evolving Cell"));
        cards.add(new Card(9,30, "Broly ssj"));
        cards.add(new Card(10,19, "Black Vegeta"));
        cards.add(new Card(11,25, "Vegito SSB"));
        cards.add(new Card(12,20, "Goku"));
        cards.add(new Card(13,20, "Vegeta"));
        cards.add(new Card(14,25, "Majin Buu"));
        cards.add(new Card(15,100, "Fusion - JOKER"));
        cards.add(new Card(16,100, "Kamehameha - JOKER"));
        cards.add(new Card(17,15, "Zarbon"));
        cards.add(new Card(18,15, "Frost"));
        cards.add(new Card(19,4, "Gohan"));
        cards.add(new Card(20,30, "Broly"));
        cards.add(new Card(21,10, "Master Roshi"));
        cards.add(new Card(22,15, "Frieza"));
        cards.add(new Card(23,5, "Pilaf"));
    }


    @Override
    protected void onPause() {
        Log.d("game", "Game paused");
        super.onPause();
    }


    @Override
    protected void onStop() {
        Log.d("game", "Game Stopped");
        super.onStop();
        stopGame(0);

    }

    @Override
    protected void onStart() {
        Log.d("game", "Game Started");
        super.onStart();
        curScore1 = curScore2 = 0;
        startGame();

    }

    Handler handler = new Handler();
    private  Runnable r = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this, DELAY);
            res = shuffle(curScore1, curScore2);
            if (res != 0)
                stopGame(res);
        }
    };


    private void initViews() {
        game_BTN_forfeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = 0;
                stopGame(res);
                finish();
            }
        });
    }

    private void findViews() {
        game_IMG_wp = findViewById(R.id.game_IMG_wp);
        game_LBL_Winner = findViewById(R.id.game_LBL_Winner);
        game_BTN_forfeit = findViewById(R.id.game_BTN_forfeit);
        game_LBL_Num1 = findViewById(R.id.game_LBL_Score1);
        game_LBL_Num2 = findViewById(R.id.game_LBL_Score2);
        game_LBL_Answer = findViewById(R.id.game_LBL_Answer);
        game_IMG_LeftCard = findViewById(R.id.game_IMG_LeftCard);
        game_IMG_RightCard = findViewById(R.id.game_IMG_RightCard);
    }

    private void stopGame(int res) {
        if(res != 0) {
            playSound(R.raw.snd_joker);
            game_LBL_Winner.setText("Player #"+res);
            game_LBL_Answer.setText("wins!");
        }else if(mp!= null)
            mp.release();
        handler.removeCallbacks(r);
    }

    private void playSound(int rawId) {
        mp = MediaPlayer.create(this, rawId);
        if(mp != null) {
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mplayer) {
                    mplayer.release();
                }
            });
        }
        mp.start();

    }

    private int shuffle(int curScore1, int curScore2){
        playSound(R.raw.snd_whip);

        num1 = (int) (1 + Math.random() * 23) -1;
        num2 = (int) (1 + Math.random() * 23) -1;

        power1 = findPowerById(num1);
        power2 = findPowerById(num2);

        showCards(num1, num2);

        if (power1 < power2){
            score2++;
            game_LBL_Answer.setText(findNameById(num2));
        }
        else if (power1 > power2) {
            score1++;
            game_LBL_Answer.setText(findNameById(num1));
        }
        else {
            game_LBL_Answer.setText("It's a Tie!");
            if(score1 > 0)
                score1--;
            if(score2 > 0)
                score2--;
        }

        game_LBL_Num1.setText("" + score1);
        game_LBL_Num2.setText("" + score2);

        if (score1 == 10) {

            winnerName  =  "Player1";
            winnerScore = score1 - score2;
            s1.setScore1(++countWins1);
            setRecord(winnerName, winnerScore);

            return 1;
        }
        else if (score2 == 10) {
            winnerName  ="Player2";
            winnerScore = score2 - score1;
            s2.setScore2(++countWins2);
            setRecord(winnerName, winnerScore);
            return 2;
        }
        return 0;
    }

    private void setRecord(String winnerName, int winnerScore) {
        Record winnerRecord = new Record(winnerName, winnerScore,0,0 );
        dataBase.insert_Record(winnerRecord);
        if (MySPV.getInstance() != null) {
            jsonInString = MySPV.getInstance().getString(KEY_DATABASE, "");
            if (jsonInString != null && jsonInString != "") {
                dataBase = gson.fromJson(jsonInString, MyDataBase.class);
            }
        }
        if (dataBase.insert_Record(new Record(winnerName, winnerScore,  -50 + Math.random() * 40, -50 + Math.random() * 40))) {
            //save
            jsonInString = gson.toJson(dataBase);
            MySPV.getInstance().putString(KEY_DATABASE, jsonInString);
            Log.d("pttt", "after enter record : " + MySPV.getInstance().getString(KEY_DATABASE, ""));
        }
    }

    private void showCards(int num1, int num2) {
        int leftCard = getResources().getIdentifier("img" + num1, "drawable", getPackageName() );
        game_IMG_LeftCard.setImageResource(leftCard);

        int rightCard = getResources().getIdentifier("img" + num2, "drawable", getPackageName() );
        game_IMG_RightCard.setImageResource(rightCard);
    }

    private int findPowerById(int id) {
        return cards.get(id).getPower();
    }
    private String findNameById(int id) {
        return cards.get(id).getName();
    }
}