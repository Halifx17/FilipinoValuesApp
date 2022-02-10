package com.example.filipinovaluesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {

    long previousTime;
    long totalTime;
    String finalTime;
    TextView Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Score = findViewById(R.id.score);
        previousTime = getIntent().getExtras().getLong("prevTime3");
        totalTime = previousTime/1000;
        finalTime = Long.toString(totalTime);
        Score.setText(finalTime);

    }
}