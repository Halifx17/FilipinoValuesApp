package com.example.filipinovaluesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Score extends AppCompatActivity {

    long previousTime;
    long totalTime;
    int runningScore = 0, totalScore = 0;
    String finalTime, finalScore;
    TextView Score, Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Score = findViewById(R.id.score);
        Time = findViewById(R.id.time);
        previousTime = getIntent().getExtras().getLong("prevTime");
        runningScore = getIntent().getIntExtra("runningScore",0);
        totalTime = previousTime/1000;
        totalScore = (int) (runningScore/totalTime);
        finalScore = Long.toString(totalScore);
        Score.setText(finalScore);
        Time.setText(Long.toString(totalTime));

        Toast.makeText(this,Integer.toString(runningScore),Toast.LENGTH_SHORT).show();
        Toast.makeText(this,Long.toString(totalTime),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Score.this);

        builder.setTitle("Do you want to return to Home Screen?");
        builder.setMessage("Your Progress Will Be Lost!");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Score.this, StartGame.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();

    }


}