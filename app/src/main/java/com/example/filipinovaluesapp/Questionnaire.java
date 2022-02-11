package com.example.filipinovaluesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Questionnaire extends AppCompatActivity {

    Button LetV, LetA, LetL, LetU, LetE, nextButton, resetButton;
    TextView L1, L2, L3, L4, L5;
    int Time = 0, score = 0, answer = 0, notAnswered = 1, seedOrder = 0;
    long previousTime;
    String strTime, txtAnswer;
    public Chronometer chronometer;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        nextButton = findViewById(R.id.nextButton);
        resetButton = findViewById(R.id.resetButton);



        LetV = findViewById(R.id.V);
        LetA= findViewById(R.id.A);
        LetL = findViewById(R.id.L);
        LetU = findViewById(R.id.U);
        LetE = findViewById(R.id.E);

        L1 = findViewById(R.id.FirstLetter);
        L2 = findViewById(R.id.SecondLetter);
        L3 = findViewById(R.id.ThirdLetter);
        L4 = findViewById(R.id.FourthLetter);
        L5 = findViewById(R.id.FifthLetter);

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
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Questionnaire.this);

        builder.setTitle("Do you want to return to Home Screen?");
        builder.setMessage("Your Progress Will Be Lost!");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Questionnaire.this, StartGame.class);
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


    public void setOpacityV(View view) {

        LetV.getBackground().setAlpha(64);
        LetV.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("V")&&
                !L2.getText().equals("V")&&
                !L3.getText().equals("V")&&
                !L4.getText().equals("V")&&
                !L5.getText().equals("V")) {

            if (L1.getText().equals("_")) {
                L1.setText("V");
            } else if (L2.getText().equals("_")) {
                L2.setText("V");
            } else if (L3.getText().equals("_")) {
                L3.setText("V");
            } else if (L4.getText().equals("_")) {
                L4.setText("V");
            } else {
                L5.setText("V");
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


    public void setOpacityL(View view) {

        LetL.getBackground().setAlpha(64);
        LetL.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("L")&&
                !L2.getText().equals("L")&&
                !L3.getText().equals("L")&&
                !L4.getText().equals("L")&&
                !L5.getText().equals("L")) {

            if (L1.getText().equals("_")) {
                L1.setText("L");
            } else if (L2.getText().equals("_")) {
                L2.setText("L");
            } else if (L3.getText().equals("_")) {
                L3.setText("L");
            } else if (L4.getText().equals("_")) {
                L4.setText("L");
            } else {
                L5.setText("L");
            }
        }

    }
    public void setOpacityU(View view) {

        LetU.getBackground().setAlpha(64);
        LetU.setTextColor(Color.parseColor("#778899"));
        if(!L1.getText().equals("U")&&
                !L2.getText().equals("U")&&
                !L3.getText().equals("U")&&
                !L4.getText().equals("U")&&
                !L5.getText().equals("U")) {

            if (L1.getText().equals("_")) {
                L1.setText("U");
            } else if (L2.getText().equals("_")) {
                L2.setText("U");
            } else if (L3.getText().equals("_")) {
                L3.setText("U");
            } else if (L4.getText().equals("_")) {
                L4.setText("U");
            } else {
                L5.setText("U");
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
                !L5.getText().equals("E")) {

            if (L1.getText().equals("_")) {
                L1.setText("E");
            } else if (L2.getText().equals("_")) {
                L2.setText("E");
            } else if (L3.getText().equals("_")) {
                L3.setText("E");
            } else if (L4.getText().equals("_")) {
                L4.setText("E");
            } else {
                L5.setText("E");
            }
        }

    }

    public void resetLetters(View view) {

        LetV.getBackground().setAlpha(255);
        LetV.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetA.getBackground().setAlpha(255);
        LetA.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetL.getBackground().setAlpha(255);
        LetL.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetU.getBackground().setAlpha(255);
        LetU.setTextColor(Color.parseColor("#FFFFFFFF"));

        LetE.getBackground().setAlpha(255);
        LetE.setTextColor(Color.parseColor("#FFFFFFFF"));


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


        if(seedOrder+1 >= 5){
            Intent intent = new Intent(Questionnaire.this, Score.class);
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

        else if(seed.get(seedOrder) == 2){
            Intent intent = new Intent(Questionnaire.this, Questionnaire1.class);
            if(txtAnswer.equals("VALUE")){

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
            Intent intent = new Intent(Questionnaire.this, Questionnaire2.class);
            if(txtAnswer.equals("VALUE")){

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
            Intent intent = new Intent(Questionnaire.this, Questionnaire3.class);
            if(txtAnswer.equals("VALUE")){

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