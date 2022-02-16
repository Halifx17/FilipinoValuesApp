package com.example.filipinovaluesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Score extends AppCompatActivity {

    long previousTime;
    long totalTime;
    int runningScore = 0, totalScore = 0, highScore, points;
    String finalTime, finalScore;
    TextView Score, Time, Points;

    public Chronometer chronometer;

    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference dbReference;
    String userID, userName, emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        dbReference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        points = getIntent().getIntExtra("points",0);

        Score = findViewById(R.id.score);
        Points = findViewById(R.id.points);
        previousTime = getIntent().getExtras().getLong("prevTime");
        runningScore = getIntent().getIntExtra("runningScore", 0);
        totalTime = previousTime / 1000;
        totalScore = (int) (runningScore / totalTime);
        finalScore = Long.toString(totalScore);
        Score.setText(finalScore);
        Points.setText(Integer.toString(points));

        chronometer = findViewById(R.id.chronometer);



            dbReference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User user = snapshot.getValue(User.class);

                    if(snapshot.hasChildren()) {

                        String name, email;
                        int score;
                        name = user.username;
                        score = user.score;
                        email = user.email;

                        userName = name;
                        highScore = score;
                        emailText = email;

                        if (highScore < totalScore) {
                            dbReference.child(userID).child("score").setValue(totalScore);
                        }
                    }




                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });
    }

    protected void onStart() {
        super.onStart();
        chronometer.setBase(SystemClock.elapsedRealtime() - previousTime);
        chronometer.stop();
    }



    @Override
    public void onBackPressed() {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Score.this);


        builder.setMessage("Return to Home Screen?");
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