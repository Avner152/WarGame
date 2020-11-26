package com.example.avners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity_Game extends AppCompatActivity {

    private static ArrayList<Card> cards = new ArrayList<>();

    final int DELAY = 1000;
    private TextView game_LBL_Num1, game_LBL_Num2, game_LBL_Answer, game_LBL_Winner;
    private ImageView game_IMG_LeftCard, game_IMG_RightCard;
    private Button game_BTN_deal, game_BTN_forfeit;
    private int num1, num2,power1, power2, score1 = 0, score2 = 0, counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__game);
        findViews();
        createCards();
        startGame();
        initViews();

    }

    private void startGame() {
    handler.postDelayed(r,DELAY);
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



    Handler handler = new Handler();
    private  Runnable r = new Runnable() {
        @Override
        public void run() {
            handler.postDelayed(this, DELAY);
            int res = shuffle();
            if (res != 0)
                stopGame(res);
        }
    };

    private void initViews() {
        game_BTN_forfeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });
    }

    private void findViews() {
        game_LBL_Winner = findViewById(R.id.game_LBL_Winner);
        game_BTN_forfeit = findViewById(R.id.game_BTN_forfeit);
        game_LBL_Num1 = findViewById(R.id.game_LBL_NUM1);
        game_LBL_Num2 = findViewById(R.id.game_LBL_NUM2);
        game_LBL_Answer = findViewById(R.id.game_LBL_Answer);
        game_IMG_LeftCard = findViewById(R.id.game_IMG_LeftCard);
        game_IMG_RightCard = findViewById(R.id.game_IMG_RightCard);
    }

    private void stopGame(int res) {
        game_LBL_Answer.setText("The Winner is: Player #" + res);
        handler.removeCallbacks(r);
    }

    private int shuffle(){
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

        if (score1 == 10)
            return 1;
        else if (score2 == 10)
            return 2;

        return 0;
    }

        private int findPowerById(int id) {
            return cards.get(id).getPower();
        }
    private String findNameById(int id) {
        return cards.get(id).getName();
    }

        private void showCards(int num1, int num2) {
            int leftCard = getResources().getIdentifier("img" + num1, "drawable", getPackageName() );
            game_IMG_LeftCard.setImageResource(leftCard);

            int rightCard = getResources().getIdentifier("img" + num2, "drawable", getPackageName() );
            game_IMG_RightCard.setImageResource(rightCard);
    }
}
