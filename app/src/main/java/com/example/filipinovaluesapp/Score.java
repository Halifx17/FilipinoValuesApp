package com.example.filipinovaluesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends AppCompatActivity {

    long previousTime;
    long totalTime;
    int runningScore = 0, totalScore = 0;
    String finalTime, finalScore;
    TextView Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Score = findViewById(R.id.score);
        previousTime = getIntent().getExtras().getLong("prevTime");
        runningScore = getIntent().getIntExtra("runningScore",0);
        totalTime = previousTime/1000;
        totalScore = (int) (runningScore/totalTime);
        finalScore = Long.toString(totalScore);
        Score.setText(finalScore);

        Toast.makeText(this,Integer.toString(runningScore),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,Long.toString(totalTime),Toast.LENGTH_SHORT).show();
    }


}