package com.example.filipinovaluesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;

public class Questionnaire7 extends AppCompatActivity {

    Button nextButton;
    EditText editAnswer;
    int Time = 0, score = 0, answer = 0, notAnswered = 1, seedOrder = 0;
    long previousTime;
    TextView questionNumber;
    String strTime, txtAnswer;
    public Chronometer chronometer;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire7);

        nextButton = findViewById(R.id.nextButton);
        editAnswer = findViewById(R.id.Edit_Answer);

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
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Questionnaire7.this);

        builder.setTitle("Return to Home Screen?");
        builder.setMessage("Your Progress Will Be Lost!");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Questionnaire7.this, StartGame.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                score = getIntent().getIntExtra("runningScore",0);
                Toast.makeText(Questionnaire7.this,Integer.toString(score),Toast.LENGTH_SHORT).show();

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




    public void settingsButton(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void nextButton1(View view) {

        score = getIntent().getIntExtra("runningScore", 0);
        ArrayList<Integer> seed = getIntent().getIntegerArrayListExtra("seed");
        seedOrder = getIntent().getIntExtra("seedOrder", 0);


        if(seedOrder+1 >= 11){
            Intent intent = new Intent(Questionnaire7.this, Score.class);
            txtAnswer = editAnswer.getText().toString().trim();
            if (txtAnswer.equalsIgnoreCase("Courage")) {
                intent.putExtra("runningScore", score);
            } else if (notAnswered == 1) {
                intent.putExtra("runningScore", score-2500);
            } else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);
        }

        else if (seed.get(seedOrder) == 1) {
            Intent intent = new Intent(Questionnaire7.this, Questionnaire.class);
            txtAnswer = editAnswer.getText().toString().trim();
            if (txtAnswer.equalsIgnoreCase("Courage")) {
                intent.putExtra("runningScore", score);
            } else if (notAnswered == 1) {
                intent.putExtra("runningScore", score-2500);
            } else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);

        } else if (seed.get(seedOrder) == 2) {
            Intent intent = new Intent(Questionnaire7.this, Questionnaire1.class);
            txtAnswer = editAnswer.getText().toString().trim();
            if (txtAnswer.equalsIgnoreCase("Courage")) {
                intent.putExtra("runningScore", score);
            } else if (notAnswered == 1) {
                intent.putExtra("runningScore", score-2500);
            } else {
                intent.putExtra("runningScore", score-2500);
            }

            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);

        } else if (seed.get(seedOrder) == 3) {
            Intent intent = new Intent(Questionnaire7.this, Questionnaire2.class);
            txtAnswer = editAnswer.getText().toString().trim();
            if (txtAnswer.equalsIgnoreCase("Courage")) {
                intent.putExtra("runningScore", score);
            } else if (notAnswered == 1) {
                intent.putExtra("runningScore", score-2500);
            } else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);

        } else if (seed.get(seedOrder) == 4) {
            Intent intent = new Intent(Questionnaire7.this, Questionnaire3.class);
            txtAnswer = editAnswer.getText().toString().trim();
            if (txtAnswer.equalsIgnoreCase("Courage")) {
                intent.putExtra("runningScore", score);
            } else if (notAnswered == 1) {
                intent.putExtra("runningScore", score-2500);
            } else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);

        }else if (seed.get(seedOrder) == 5) {
            Intent intent = new Intent(Questionnaire7.this, Questionnaire4.class);
            txtAnswer = editAnswer.getText().toString().trim();
            if (txtAnswer.equalsIgnoreCase("Courage")) {
                intent.putExtra("runningScore", score);
            } else if (notAnswered == 1) {
                intent.putExtra("runningScore", score-2500);
            } else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);

        } else if (seed.get(seedOrder) == 6) {
            Intent intent = new Intent(Questionnaire7.this, Questionnaire5.class);
            txtAnswer = editAnswer.getText().toString().trim();
            if (txtAnswer.equalsIgnoreCase("Courage")) {
                intent.putExtra("runningScore", score);
            } else if (notAnswered == 1) {
                intent.putExtra("runningScore", score-2500);
            } else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);

        } else if (seed.get(seedOrder) == 7) {
            Intent intent = new Intent(Questionnaire7.this, Questionnaire6.class);
            txtAnswer = editAnswer.getText().toString().trim();
            if (txtAnswer.equalsIgnoreCase("Courage")) {
                intent.putExtra("runningScore", score);
            } else if (notAnswered == 1) {
                intent.putExtra("runningScore", score-2500);
            } else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);

        }else if (seed.get(seedOrder) == 9) {
            Intent intent = new Intent(Questionnaire7.this, Questionnaire8.class);
            txtAnswer = editAnswer.getText().toString().trim();
            if (txtAnswer.equalsIgnoreCase("Courage")) {
                intent.putExtra("runningScore", score);
            } else if (notAnswered == 1) {
                intent.putExtra("runningScore", score-2500);
            } else {
                intent.putExtra("runningScore", score-2500);
            }
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            intent.putExtra("prevTime", elapsedMillis);
            intent.putExtra("seedOrder", seedOrder + 1);
            intent.putIntegerArrayListExtra("seed", seed);
            startActivity(intent);

        }else if (seed.get(seedOrder) == 10) {
            Intent intent = new Intent(Questionnaire7.this, Questionnaire9.class);
            txtAnswer = editAnswer.getText().toString().trim();
            if (txtAnswer.equalsIgnoreCase("Courage")) {
                intent.putExtra("runningScore", score);
            } else if (notAnswered == 1) {
                intent.putExtra("runningScore", score-2500);
            } else {
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