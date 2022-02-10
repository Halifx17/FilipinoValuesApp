package com.example.filipinovaluesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.Toast;

public class Questionnaire3 extends AppCompatActivity {

    Button nextButton;
    EditText editAnswer;
    int Time = 0;
    long previousTime;
    String strTime;
    public Chronometer chronometer;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire3);

        nextButton = findViewById(R.id.nextButton);
        editAnswer = findViewById(R.id.Edit_Answer);

        previousTime = getIntent().getExtras().getLong("prevTime2");

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




    public void settingsButton(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void nextButton1(View view) {

        String answer;

        answer = editAnswer.getText().toString().trim();

        Toast.makeText(Questionnaire3.this,answer,Toast.LENGTH_SHORT).show();

        long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
        Intent intent = new Intent(Questionnaire3.this,Score.class);
        intent.putExtra("prevTime3",elapsedMillis);
        startActivity(intent);

    }


}