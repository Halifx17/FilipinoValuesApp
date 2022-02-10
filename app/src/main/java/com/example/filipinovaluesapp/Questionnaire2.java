package com.example.filipinovaluesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class Questionnaire2 extends AppCompatActivity {

    Button q2Choice1, q2Choice2, q2Choice3, q2Choice4, nextButton;
    int Time = 0;
    long previousTime;
    String strTime;
    public Chronometer chronometer;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire2);

        nextButton = findViewById(R.id.nextButton);


        q2Choice1 = findViewById(R.id.q2Choice1);
        q2Choice2 = findViewById(R.id.q2Choice2);
        q2Choice3 = findViewById(R.id.q2Choice3);
        q2Choice4 = findViewById(R.id.q2Choice4);

        previousTime = getIntent().getExtras().getLong("prevTime1");

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

        q2Choice1.getBackground().setAlpha(255);
        q2Choice1.setTextColor(Color.parseColor("#FFFFFFFF"));
        q2Choice2.getBackground().setAlpha(255);
        q2Choice2.setTextColor(Color.parseColor("#FFFFFFFF"));
        q2Choice3.getBackground().setAlpha(255);
        q2Choice3.setTextColor(Color.parseColor("#FFFFFFFF"));
        q2Choice4.getBackground().setAlpha(255);
        q2Choice4.setTextColor(Color.parseColor("#FFFFFFFF"));
    }

    public void settingsButton(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }



    public void MCQ1(View view) {

        clearSelection();
        q2Choice2.getBackground().setAlpha(64);
        q2Choice2.setTextColor(Color.parseColor("#778899"));
        q2Choice3.getBackground().setAlpha(64);
        q2Choice3.setTextColor(Color.parseColor("#778899"));
        q2Choice4.getBackground().setAlpha(64);
        q2Choice4.setTextColor(Color.parseColor("#778899"));
    }

    public void MCQ2(View view) {

        clearSelection();

        q2Choice1.getBackground().setAlpha(64);
        q2Choice1.setTextColor(Color.parseColor("#778899"));
        q2Choice3.getBackground().setAlpha(64);
        q2Choice3.setTextColor(Color.parseColor("#778899"));
        q2Choice4.getBackground().setAlpha(64);
        q2Choice4.setTextColor(Color.parseColor("#778899"));

    }

    public void MCQ3(View view) {
        clearSelection();
        q2Choice1.getBackground().setAlpha(64);
        q2Choice1.setTextColor(Color.parseColor("#778899"));
        q2Choice2.getBackground().setAlpha(64);
        q2Choice2.setTextColor(Color.parseColor("#778899"));
        q2Choice4.getBackground().setAlpha(64);
        q2Choice4.setTextColor(Color.parseColor("#778899"));
    }

    public void MCQ4(View view) {
        clearSelection();
        q2Choice1.getBackground().setAlpha(64);
        q2Choice1.setTextColor(Color.parseColor("#778899"));
        q2Choice3.getBackground().setAlpha(64);
        q2Choice3.setTextColor(Color.parseColor("#778899"));
        q2Choice2.getBackground().setAlpha(64);
        q2Choice2.setTextColor(Color.parseColor("#778899"));
    }

    public void nextButton1(View view) {
        long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
        Intent intent = new Intent(Questionnaire2.this,Questionnaire3.class);
        intent.putExtra("prevTime2",elapsedMillis);
        startActivity(intent);
    }
}

