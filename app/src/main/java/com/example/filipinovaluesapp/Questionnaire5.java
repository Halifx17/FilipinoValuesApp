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

public class Questionnaire5 extends AppCompatActivity {

    Button choiceOne, choiceTwo, choiceThree, choiceFour, nextButton;
    int Time = 0, score = 0, answer = 0, notAnswered = 1, seedOrder = 0;
    long previousTime;
    String strTime;
    TextView questionNumber;
    public Chronometer chronometer;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire5);

        nextButton = findViewById(R.id.nextButton);

        choiceOne = findViewById(R.id.Choice1);
        choiceTwo = findViewById(R.id.Choice2);
        choiceThree = findViewById(R.id.Choice3);
        choiceFour = findViewById(R.id.Choice4);

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
    }

    @Override
    public void onBackPressed() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Questionnaire5.this);

        builder.setTitle("Return to Home Screen?");
        builder.setMessage("Your Progress Will Be Lost!");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Questionnaire5.this, StartGame.class);
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

    protected void onStart() {
        super.onStart();
        chronometer.setBase(SystemClock.elapsedRealtime() - previousTime);
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

    public void clearSelection(){

        choiceOne.getBackground().setAlpha(255);
        choiceOne.setTextColor(Color.parseColor("#FFFFFFFF"));
        choiceTwo.getBackground().setAlpha(255);
        choiceTwo.setTextColor(Color.parseColor("#FFFFFFFF"));
        choiceThree.getBackground().setAlpha(255);
        choiceThree.setTextColor(Color.parseColor("#FFFFFFFF"));
        choiceFour.getBackground().setAlpha(255);
        choiceFour.setTextColor(Color.parseColor("#FFFFFFFF"));
        answer = 0;
        notAnswered = 1;

    }

    public void settingsButton(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);

    }



    public void MCQ1(View view) {

        clearSelection();
        choiceTwo.getBackground().setAlpha(64);
        choiceTwo.setTextColor(Color.parseColor("#778899"));
        choiceThree.getBackground().setAlpha(64);
        choiceThree.setTextColor(Color.parseColor("#778899"));
        choiceFour.getBackground().setAlpha(64);
        choiceFour.setTextColor(Color.parseColor("#778899"));
        answer = 1;
        notAnswered = 0;
    }

    public void MCQ2(View view) {

        clearSelection();

        choiceOne.getBackground().setAlpha(64);
        choiceOne.setTextColor(Color.parseColor("#778899"));
        choiceThree.getBackground().setAlpha(64);
        choiceThree.setTextColor(Color.parseColor("#778899"));
        choiceFour.getBackground().setAlpha(64);
        choiceFour.setTextColor(Color.parseColor("#778899"));
        answer = 0;
        notAnswered = 0;


    }

    public void MCQ3(View view) {
        clearSelection();
        choiceOne.getBackground().setAlpha(64);
        choiceOne.setTextColor(Color.parseColor("#778899"));
        choiceTwo.getBackground().setAlpha(64);
        choiceTwo.setTextColor(Color.parseColor("#778899"));
        choiceFour.getBackground().setAlpha(64);
        choiceFour.setTextColor(Color.parseColor("#778899"));
        answer = 0;
        notAnswered = 0;
    }

    public void MCQ4(View view) {
        clearSelection();
        choiceOne.getBackground().setAlpha(64);
        choiceOne.setTextColor(Color.parseColor("#778899"));
        choiceThree.getBackground().setAlpha(64);
        choiceThree.setTextColor(Color.parseColor("#778899"));
        choiceTwo.getBackground().setAlpha(64);
        choiceTwo.setTextColor(Color.parseColor("#778899"));
        answer = 0;
        notAnswered = 0;
    }

    public void nextButton1(View view) {


        score = getIntent().getIntExtra("runningScore", 0);
        ArrayList<Integer> seed = getIntent().getIntegerArrayListExtra("seed");
        seedOrder = getIntent().getIntExtra("seedOrder", 0);

        if(seedOrder+1 >= 11){
            Intent intent = new Intent(Questionnaire5.this, Score.class);
            if (answer == 1) {

                intent.putExtra("runningScore", score);
            } else if(notAnswered == 1){
                intent.putExtra("runningScore", score-2500);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        }

        else if (seed.get(seedOrder) == 1) {
            Intent intent = new Intent(Questionnaire5.this, Questionnaire.class);
            if (answer == 1) {

                intent.putExtra("runningScore", score);
            } else if(notAnswered == 1){
                intent.putExtra("runningScore", score-2500);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        } else if (seed.get(seedOrder) == 2) {
            Intent intent = new Intent(Questionnaire5.this, Questionnaire1.class);
            if (answer == 1) {

                intent.putExtra("runningScore", score);
            } else if(notAnswered == 1){
                intent.putExtra("runningScore", score-2500);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        } else if (seed.get(seedOrder) == 3) {
            Intent intent = new Intent(Questionnaire5.this, Questionnaire2.class);
            if (answer == 1) {

                intent.putExtra("runningScore", score);
            } else if(notAnswered == 1){
                intent.putExtra("runningScore", score-2500);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        }
        else if (seed.get(seedOrder) == 4) {
            Intent intent = new Intent(Questionnaire5.this, Questionnaire3.class);
            if (answer == 1) {

                intent.putExtra("runningScore", score);
            } else if(notAnswered == 1){
                intent.putExtra("runningScore", score-2500);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        }
        else if (seed.get(seedOrder) == 5) {
            Intent intent = new Intent(Questionnaire5.this, Questionnaire4.class);
            if (answer == 1) {

                intent.putExtra("runningScore", score);
            } else if(notAnswered == 1){
                intent.putExtra("runningScore", score-2500);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        }else if (seed.get(seedOrder) == 7) {
            Intent intent = new Intent(Questionnaire5.this, Questionnaire6.class);
            if (answer == 1) {

                intent.putExtra("runningScore", score);
            } else if(notAnswered == 1){
                intent.putExtra("runningScore", score-2500);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        }else if (seed.get(seedOrder) == 8) {
            Intent intent = new Intent(Questionnaire5.this, Questionnaire7.class);
            if (answer == 1) {

                intent.putExtra("runningScore", score);
            } else if(notAnswered == 1){
                intent.putExtra("runningScore", score-2500);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        }else if (seed.get(seedOrder) == 9) {
            Intent intent = new Intent(Questionnaire5.this, Questionnaire8.class);
            if (answer == 1) {

                intent.putExtra("runningScore", score);
            } else if(notAnswered == 1){
                intent.putExtra("runningScore", score-2500);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        }else if (seed.get(seedOrder) == 10) {
            Intent intent = new Intent(Questionnaire5.this, Questionnaire9.class);
            if (answer == 1) {

                intent.putExtra("runningScore", score);
            } else if(notAnswered == 1){
                intent.putExtra("runningScore", score-2500);
            }else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        }
    }
}