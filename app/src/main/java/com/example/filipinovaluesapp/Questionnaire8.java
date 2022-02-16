package com.example.filipinovaluesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class Questionnaire8 extends AppCompatActivity {

    Button LetK, LetA, LetR, LetM, LetÀ, nextButton, resetButton;
    TextView L1, L2, L3, L4, L5;
    int Time = 0, score = 0, answer = 0, notAnswered = 1, seedOrder = 0, points;
    long previousTime;
    TextView questionNumber;
    String strTime, txtAnswer;
    public Chronometer chronometer;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire8);

        nextButton = findViewById(R.id.nextButton);
        resetButton = findViewById(R.id.resetButton);



        LetK = findViewById(R.id.K);
        LetA= findViewById(R.id.A);
        LetR = findViewById(R.id.R);
        LetM = findViewById(R.id.M);
        LetÀ = findViewById(R.id.À);

        L1 = findViewById(R.id.FirstLetter);
        L2 = findViewById(R.id.SecondLetter);
        L3 = findViewById(R.id.ThirdLetter);
        L4 = findViewById(R.id.FourthLetter);
        L5 = findViewById(R.id.FifthLetter);

        seedOrder = getIntent().getIntExtra("seedOrder",0);
        questionNumber = findViewById(R.id.questionNumber);
        questionNumber.setText(Integer.toString(seedOrder));
        points = getIntent().getIntExtra("points",0);

        previousTime = getIntent().getExtras().getLong("prevTime");

        chronometer = findViewById(R.id.chronometer);

        nextButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(MotionEvent.ACTION_DOWN == motionEvent.getAction()) {
                    view.getBackground().setAlpha(128);

                }else if(MotionEvent.ACTION_UP == motionEvent.getAction()) {
                    view.getBackground().setAlpha(255);


                }

                return false;
            }
        });

        resetButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(MotionEvent.ACTION_DOWN == motionEvent.getAction()) {
                    view.getBackground().setAlpha(128);

                }else if(MotionEvent.ACTION_UP == motionEvent.getAction()) {
                    view.getBackground().setAlpha(255);


                }

                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Questionnaire8.this);

        builder.setTitle("Return to Home Screen?");
        builder.setMessage("Your Progress Will Be Lost!");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Questionnaire8.this, StartGame.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();

    }



    @Override
    protected void onStart() {
        super.onStart();
        chronometer.setBase(SystemClock.elapsedRealtime()-previousTime);
        chronometer.start();
    }

    public void startChronometer(View view){
        if(!running){
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View view){
        if(running){
            chronometer.stop();
            running = false;
        }
    }

    public void settingsButton(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);



    }


    public void setOpacityK(View view) {

        LetK.getBackground().setAlpha(64);
        LetK.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("K")&&
                !L2.getText().equals("K")&&
                !L3.getText().equals("K")&&
                !L4.getText().equals("K")&&
                !L5.getText().equals("K")) {

            if (L1.getText().equals("_")) {
                L1.setText("K");
            } else if (L2.getText().equals("_")) {
                L2.setText("K");
            } else if (L3.getText().equals("_")) {
                L3.setText("K");
            } else if (L4.getText().equals("_")) {
                L4.setText("K");
            } else {
                L5.setText("K");
            }
        }
    }


    public void setOpacityA(View view) {

        LetA.getBackground().setAlpha(64);
        LetA.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("A")&&
                !L2.getText().equals("A")&&
                !L3.getText().equals("A")&&
                !L4.getText().equals("A")&&
                !L5.getText().equals("A")) {

            if (L1.getText().equals("_")) {
                L1.setText("A");
            } else if (L2.getText().equals("_")) {
                L2.setText("A");
            } else if (L3.getText().equals("_")) {
                L3.setText("A");
            } else if (L4.getText().equals("_")) {
                L4.setText("A");
            } else {
                L5.setText("A");
            }
        }
    }


    public void setOpacityR(View view) {

        LetR.getBackground().setAlpha(64);
        LetR.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("R")&&
                !L2.getText().equals("R")&&
                !L3.getText().equals("R")&&
                !L4.getText().equals("R")&&
                !L5.getText().equals("R")) {

            if (L1.getText().equals("_")) {
                L1.setText("R");
            } else if (L2.getText().equals("_")) {
                L2.setText("R");
            } else if (L3.getText().equals("_")) {
                L3.setText("R");
            } else if (L4.getText().equals("_")) {
                L4.setText("R");
            } else {
                L5.setText("R");
            }
        }

    }
    public void setOpacityM(View view) {

        LetM.getBackground().setAlpha(64);
        LetM.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("M")&&
                !L2.getText().equals("M")&&
                !L3.getText().equals("M")&&
                !L4.getText().equals("M")&&
                !L5.getText().equals("M")) {

            if (L1.getText().equals("_")) {
                L1.setText("M");
            } else if (L2.getText().equals("_")) {
                L2.setText("M");
            } else if (L3.getText().equals("_")) {
                L3.setText("M");
            } else if (L4.getText().equals("_")) {
                L4.setText("M");
            } else {
                L5.setText("M");
            }
        }

    }


    public void setOpacityÀ(View view) {

        LetÀ.getBackground().setAlpha(64);
        LetÀ.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("À")&&
                !L2.getText().equals("À")&&
                !L3.getText().equals("À")&&
                !L4.getText().equals("À")&&
                !L5.getText().equals("À")) {

            if (L1.getText().equals("_")) {
                L1.setText("À");
            } else if (L2.getText().equals("_")) {
                L2.setText("À");
            } else if (L3.getText().equals("_")) {
                L3.setText("À");
            } else if (L4.getText().equals("_")) {
                L4.setText("À");
            } else {
                L5.setText("À");
            }
        }

    }

    public void resetLetters(View view) {

        LetK.getBackground().setAlpha(255);
        LetK.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetA.getBackground().setAlpha(255);
        LetA.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetR.getBackground().setAlpha(255);
        LetR.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetM.getBackground().setAlpha(255);
        LetM.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetÀ.getBackground().setAlpha(255);
        LetÀ.setTextColor(Color.parseColor("#FFFFFFFF"));


        L1.setText("_");
        L2.setText("_");
        L3.setText("_");
        L4.setText("_");
        L5.setText("_");


    }

    public void nextButton(View view) {

        score = getIntent().getIntExtra("runningScore",0);
        txtAnswer = (String) L1.getText()+L2.getText()+L3.getText()+L4.getText()+L5.getText();
        ArrayList<Integer> seed = getIntent().getIntegerArrayListExtra("seed");
        seedOrder = getIntent().getIntExtra("seedOrder",0);


        if(seedOrder+1 >= 11){
            Intent intent = new Intent(Questionnaire8.this, Score.class);
            if (txtAnswer.equals("KARMÀ")||txtAnswer.equals("KÀRMA")) {
                intent.putExtra("runningScore", score);
                intent.putExtra("points", points+1);
            } else {
                intent.putExtra("runningScore", score-100000);
                intent.putExtra("points", points);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        }
        else if(seed.get(seedOrder) == 1){
            Intent intent = new Intent(Questionnaire8.this, Questionnaire.class);
            if(txtAnswer.equals("KARMÀ")||txtAnswer.equals("KÀRMA")){

                intent.putExtra("runningScore", score);
                intent.putExtra("points", points+1);
            }else {
                intent.putExtra("runningScore", score-100000);
                intent.putExtra("points", points);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }


        else if(seed.get(seedOrder) == 2){
            Intent intent = new Intent(Questionnaire8.this, Questionnaire1.class);
            if(txtAnswer.equals("KARMÀ")||txtAnswer.equals("KÀRMA")){

                intent.putExtra("runningScore", score);
                intent.putExtra("points", points+1);
            }else {
                intent.putExtra("runningScore", score-100000);
                intent.putExtra("points", points);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }
        else if(seed.get(seedOrder) == 3){
            Intent intent = new Intent(Questionnaire8.this, Questionnaire2.class);
            if(txtAnswer.equals("KARMÀ")||txtAnswer.equals("KÀRMA")){

                intent.putExtra("runningScore", score);
                intent.putExtra("points", points+1);
            }else {
                intent.putExtra("runningScore", score-100000);
                intent.putExtra("points", points);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }
        else if(seed.get(seedOrder) == 4){
            Intent intent = new Intent(Questionnaire8.this, Questionnaire3.class);
            if(txtAnswer.equals("KARMÀ")||txtAnswer.equals("KÀRMA")){

                intent.putExtra("runningScore", score);
                intent.putExtra("points", points+1);
            }else {
                intent.putExtra("runningScore", score-100000);
                intent.putExtra("points", points);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }
        else if(seed.get(seedOrder) == 5){
            Intent intent = new Intent(Questionnaire8.this, Questionnaire4.class);
            if(txtAnswer.equals("KARMÀ")||txtAnswer.equals("KÀRMA")){

                intent.putExtra("runningScore", score);
                intent.putExtra("points", points+1);
            }else {
                intent.putExtra("runningScore", score-100000);
                intent.putExtra("points", points);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }
        else if(seed.get(seedOrder) == 6){
            Intent intent = new Intent(Questionnaire8.this, Questionnaire5.class);
            if(txtAnswer.equals("KARMÀ")||txtAnswer.equals("KÀRMA")){

                intent.putExtra("runningScore", score);
                intent.putExtra("points", points+1);
            }else {
                intent.putExtra("runningScore", score-100000);
                intent.putExtra("points", points);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 7){
            Intent intent = new Intent(Questionnaire8.this, Questionnaire6.class);
            if(txtAnswer.equals("KARMÀ")||txtAnswer.equals("KÀRMA")){

                intent.putExtra("runningScore", score);
                intent.putExtra("points", points+1);
            }else {
                intent.putExtra("runningScore", score-100000);
                intent.putExtra("points", points);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 8){
            Intent intent = new Intent(Questionnaire8.this, Questionnaire7.class);
            if(txtAnswer.equals("KARMÀ")||txtAnswer.equals("KÀRMA")){

                intent.putExtra("runningScore", score);
                intent.putExtra("points", points+1);
            }else {
                intent.putExtra("runningScore", score-100000);
                intent.putExtra("points", points);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 10){
            Intent intent = new Intent(Questionnaire8.this, Questionnaire9.class);
            if(txtAnswer.equals("KARMÀ")||txtAnswer.equals("KÀRMA")){

                intent.putExtra("runningScore", score);
                intent.putExtra("points", points+1);
            }else {
                intent.putExtra("runningScore", score-100000);
                intent.putExtra("points", points);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }

    }

}