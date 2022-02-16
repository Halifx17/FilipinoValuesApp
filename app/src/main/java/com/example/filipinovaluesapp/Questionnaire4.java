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

public class Questionnaire4 extends AppCompatActivity {

    Button LetR, LetE, LetS, LetP, LetT, LetO, LetE2, nextButton, resetButton;
    TextView L1, L2, L3, L4, L5, L6, L7;
    int Time = 0, score = 0, answer = 0, notAnswered = 1, seedOrder = 0;
    long previousTime;
    TextView questionNumber;
    String strTime, txtAnswer;
    public Chronometer chronometer;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire4);

        nextButton = findViewById(R.id.nextButton);
        resetButton = findViewById(R.id.resetButton);



        LetR = findViewById(R.id.R);
        LetE= findViewById(R.id.E);
        LetS = findViewById(R.id.S);
        LetP = findViewById(R.id.P);
        LetE2 = findViewById(R.id.E2);
        LetT = findViewById(R.id.T);
        LetO = findViewById(R.id.O);


        L1 = findViewById(R.id.FirstLetter);
        L2 = findViewById(R.id.SecondLetter);
        L3 = findViewById(R.id.ThirdLetter);
        L4 = findViewById(R.id.FourthLetter);
        L5 = findViewById(R.id.FifthLetter);
        L6 = findViewById(R.id.SixthLetter);
        L7 = findViewById(R.id.SeventhLetter);

        seedOrder = getIntent().getIntExtra("seedOrder",0);
        questionNumber = findViewById(R.id.questionNumber);
        questionNumber.setText(Integer.toString(seedOrder));

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
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Questionnaire4.this);

        builder.setTitle("Return to Home Screen?");
        builder.setMessage("Your Progress Will Be Lost!");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Questionnaire4.this, StartGame.class);
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


    public void setOpacityR(View view) {

        LetR.getBackground().setAlpha(64);
        LetR.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("R")&&
                !L2.getText().equals("R")&&
                !L3.getText().equals("R")&&
                !L4.getText().equals("R")&&
                !L5.getText().equals("R")&&
                !L6.getText().equals("R")&&
                !L7.getText().equals("R")) {

            if (L1.getText().equals("_")) {
                L1.setText("R");
            } else if (L2.getText().equals("_")) {
                L2.setText("R");
            } else if (L3.getText().equals("_")) {
                L3.setText("R");
            } else if (L4.getText().equals("_")) {
                L4.setText("R");
            } else if(L5.getText().equals("_")){
                L5.setText("R");
            } else if(L6.getText().equals("_")){
                L6.setText("R");
            }else if(L7.getText().equals("_")){
                L7.setText("R");
            }
        }
    }


    public void setOpacityE2(View view) {

        LetE2.getBackground().setAlpha(64);
        LetE2.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("É")&&
                !L2.getText().equals("É")&&
                !L3.getText().equals("É")&&
                !L4.getText().equals("É")&&
                !L5.getText().equals("É")&&
                !L6.getText().equals("É")&&
                !L7.getText().equals("É")) {

            if (L1.getText().equals("_")) {
                L1.setText("É");
            } else if (L2.getText().equals("_")) {
                L2.setText("É");
            } else if (L3.getText().equals("_")) {
                L3.setText("É");
            } else if (L4.getText().equals("_")) {
                L4.setText("É");
            } else if(L5.getText().equals("_")){
                L5.setText("É");
            } else if(L6.getText().equals("_")){
                L6.setText("É");
            }else if(L7.getText().equals("_")){
                L7.setText("É");
            }
        }
    }


    public void setOpacityS(View view) {

        LetS.getBackground().setAlpha(64);
        LetS.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("S")&&
                !L2.getText().equals("S")&&
                !L3.getText().equals("S")&&
                !L4.getText().equals("S")&&
                !L5.getText().equals("S")&&
                !L6.getText().equals("S")&&
                !L7.getText().equals("S")) {

            if (L1.getText().equals("_")) {
                L1.setText("S");
            } else if (L2.getText().equals("_")) {
                L2.setText("S");
            } else if (L3.getText().equals("_")) {
                L3.setText("S");
            } else if (L4.getText().equals("_")) {
                L4.setText("S");
            } else if(L5.getText().equals("_")){
                L5.setText("S");
            } else if(L6.getText().equals("_")){
                L6.setText("S");
            }else if(L7.getText().equals("_")){
                L7.setText("S");
            }
        }

    }
    public void setOpacityP(View view) {

        LetP.getBackground().setAlpha(64);
        LetP.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("P")&&
                !L2.getText().equals("P")&&
                !L3.getText().equals("P")&&
                !L4.getText().equals("P")&&
                !L5.getText().equals("P")&&
                !L6.getText().equals("P")&&
                !L7.getText().equals("P")) {

            if (L1.getText().equals("_")) {
                L1.setText("P");
            } else if (L2.getText().equals("_")) {
                L2.setText("P");
            } else if (L3.getText().equals("_")) {
                L3.setText("P");
            } else if (L4.getText().equals("_")) {
                L4.setText("P");
            } else if(L5.getText().equals("_")){
                L5.setText("P");
            } else if(L6.getText().equals("_")){
                L6.setText("P");
            }else if(L7.getText().equals("_")){
                L7.setText("P");
            }
        }

    }


    public void setOpacityE(View view) {

        LetE.getBackground().setAlpha(64);
        LetE.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("E")&&
                !L2.getText().equals("E")&&
                !L3.getText().equals("E")&&
                !L4.getText().equals("E")&&
                !L5.getText().equals("E")&&
                !L6.getText().equals("E")&&
                !L7.getText().equals("E")) {

            if (L1.getText().equals("_")) {
                L1.setText("E");
            } else if (L2.getText().equals("_")) {
                L2.setText("E");
            } else if (L3.getText().equals("_")) {
                L3.setText("E");
            } else if (L4.getText().equals("_")) {
                L4.setText("E");
            } else if(L5.getText().equals("_")){
                L5.setText("E");
            } else if(L6.getText().equals("_")){
                L6.setText("E");
            }else if(L7.getText().equals("_")){
                L7.setText("E");
            }
        }

    }

    public void setOpacityT(View view) {

        LetT.getBackground().setAlpha(64);
        LetT.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("T")&&
                !L2.getText().equals("T")&&
                !L3.getText().equals("T")&&
                !L4.getText().equals("T")&&
                !L5.getText().equals("T")&&
                !L6.getText().equals("T")&&
                !L7.getText().equals("T")) {

            if (L1.getText().equals("_")) {
                L1.setText("T");
            } else if (L2.getText().equals("_")) {
                L2.setText("T");
            } else if (L3.getText().equals("_")) {
                L3.setText("T");
            } else if (L4.getText().equals("_")) {
                L4.setText("T");
            } else if(L5.getText().equals("_")){
                L5.setText("T");
            } else if(L6.getText().equals("_")){
                L6.setText("T");
            }else if(L7.getText().equals("_")){
                L7.setText("T");
            }
        }

    }

    public void setOpacityO(View view) {

        LetO.getBackground().setAlpha(64);
        LetO.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("O")&&
                !L2.getText().equals("O")&&
                !L3.getText().equals("O")&&
                !L4.getText().equals("O")&&
                !L5.getText().equals("O")&&
                !L6.getText().equals("O")&&
                !L7.getText().equals("O")) {

            if (L1.getText().equals("_")) {
                L1.setText("O");
            } else if (L2.getText().equals("_")) {
                L2.setText("O");
            } else if (L3.getText().equals("_")) {
                L3.setText("O");
            } else if (L4.getText().equals("_")) {
                L4.setText("O");
            } else if(L5.getText().equals("_")){
                L5.setText("O");
            } else if(L6.getText().equals("_")){
                L6.setText("O");
            }else if(L7.getText().equals("_")){
                L7.setText("O");
            }
        }

    }

    public void resetLetters(View view) {

        LetR.getBackground().setAlpha(255);
        LetR.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetE2.getBackground().setAlpha(255);
        LetE2.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetS.getBackground().setAlpha(255);
        LetS.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetP.getBackground().setAlpha(255);
        LetP.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetE.getBackground().setAlpha(255);
        LetE.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetT.getBackground().setAlpha(255);
        LetT.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetO.getBackground().setAlpha(255);
        LetO.setTextColor(Color.parseColor("#FFFFFFFF"));


        L1.setText("_");
        L2.setText("_");
        L3.setText("_");
        L4.setText("_");
        L5.setText("_");
        L6.setText("_");
        L7.setText("_");


    }

    public void nextButton(View view) {

        score = getIntent().getIntExtra("runningScore",0);
        txtAnswer = (String) L1.getText()+L2.getText()+L3.getText()+L4.getText()+L5.getText()+L6.getText()+L7.getText();
        ArrayList<Integer> seed = getIntent().getIntegerArrayListExtra("seed");
        seedOrder = getIntent().getIntExtra("seedOrder",0);


        if(seedOrder+1 >= 11){
            Intent intent = new Intent(Questionnaire4.this, Score.class);
            if (answer == 1) {
                intent.putExtra("runningScore", score);
            } else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        }
        else if(seed.get(seedOrder) == 1){
            Intent intent = new Intent(Questionnaire4.this, Questionnaire.class);
            if(txtAnswer.equals("RÉSPETO")||txtAnswer.equals("RESPÉTO")){

                intent.putExtra("runningScore", score);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }


        else if(seed.get(seedOrder) == 2){
            Intent intent = new Intent(Questionnaire4.this, Questionnaire1.class);
            if(txtAnswer.equals("RÉSPETO")||txtAnswer.equals("RESPÉTO")){

                intent.putExtra("runningScore", score);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }
        else if(seed.get(seedOrder) == 3){
            Intent intent = new Intent(Questionnaire4.this, Questionnaire2.class);
            if(txtAnswer.equals("RÉSPETO")||txtAnswer.equals("RESPÉTO")){

                intent.putExtra("runningScore", score);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }
        else if(seed.get(seedOrder) == 4){
            Intent intent = new Intent(Questionnaire4.this, Questionnaire3.class);
            if(txtAnswer.equals("RÉSPETO")||txtAnswer.equals("RESPÉTO")){

                intent.putExtra("runningScore", score);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }
        else if(seed.get(seedOrder) == 6){
            Intent intent = new Intent(Questionnaire4.this, Questionnaire5.class);
            if(txtAnswer.equals("RÉSPETO")||txtAnswer.equals("RESPÉTO")){

                intent.putExtra("runningScore", score);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 7){
            Intent intent = new Intent(Questionnaire4.this, Questionnaire6.class);
            if(txtAnswer.equals("RÉSPETO")||txtAnswer.equals("RESPÉTO")){

                intent.putExtra("runningScore", score);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 8){
            Intent intent = new Intent(Questionnaire4.this, Questionnaire7.class);
            if(txtAnswer.equals("RÉSPETO")||txtAnswer.equals("RESPÉTO")){

                intent.putExtra("runningScore", score);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 9){
            Intent intent = new Intent(Questionnaire4.this, Questionnaire8.class);
            if(txtAnswer.equals("RÉSPETO")||txtAnswer.equals("RESPÉTO")){

                intent.putExtra("runningScore", score);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 10){
            Intent intent = new Intent(Questionnaire4.this, Questionnaire9.class);
            if(txtAnswer.equals("RÉSPETO")||txtAnswer.equals("RESPÉTO")){

                intent.putExtra("runningScore", score);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime",elapsedMillis);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }

    }
}