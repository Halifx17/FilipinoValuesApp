package com.example.filipinovaluesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StartGame extends AppCompatActivity {


    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference dbReference;
    String userID, userName, emailText, highScore;

    Button startGame, howToPlay, leaderBoards;
    int baseScore = 100000, seedOrder = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        mAuth=FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        dbReference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();


        startGame = findViewById(R.id.startGame);
        howToPlay = findViewById(R.id.howToPlay);
        leaderBoards = findViewById(R.id.Leaderboards);


        dbReference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);

                if(user!=null){
                    String name, email;
                    int score;

                    name = user.username;
                    email = user.email;
                    score = user.score;

                    userName = name;
                    emailText = email;
                    highScore = Integer.toString(score);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        startGame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                if (MotionEvent.ACTION_DOWN == motionEvent.getAction()) {
                    view.getBackground().setAlpha(128);

                } else if (MotionEvent.ACTION_UP == motionEvent.getAction()) {
                    view.getBackground().setAlpha(255);


                }


                return false;
            }
        });
        howToPlay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                if (MotionEvent.ACTION_DOWN == motionEvent.getAction()) {
                    view.getBackground().setAlpha(128);

                } else if (MotionEvent.ACTION_UP == motionEvent.getAction()) {
                    view.getBackground().setAlpha(255);


                }


                return false;
            }
        });

        leaderBoards.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                if (MotionEvent.ACTION_DOWN == motionEvent.getAction()) {
                    view.getBackground().setAlpha(128);

                } else if (MotionEvent.ACTION_UP == motionEvent.getAction()) {
                    view.getBackground().setAlpha(255);


                }


                return false;
            }
        });


    }

    public void settingsButton(View view) {
        Intent intent = new Intent(this, Settings.class);
        intent.putExtra("username",userName);
        intent.putExtra("email",emailText);
        intent.putExtra("highScore", highScore);

        startActivity(intent);





    }

    public void gameStart(View view) {
        ArrayList<Integer> seed = new ArrayList<Integer>();

        for (int count = 0; count <= 3; count++) {
            seed.add(count, (int) Math.floor((Math.random() * 4) + 1));
            int i = 0;
            while (i != 1 && seed.size() >= 2 && seed.size() <= 4) {
                if (seed.size() == 2) {
                    if (seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 4) + 1));
                        i = 0;
                    } else {
                        i = 1;
                    }

                } else if (seed.size() == 3) {
                    if (seed.get(count) == seed.get(count - 2)
                            ||seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 4) + 1));
                        i = 0;
                    } else
                        i = 1;
                } else if (seed.size() == 4) {
                    if (seed.get(count) == seed.get(count - 3)
                            ||seed.get(count) == seed.get(count - 2)
                            ||seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 4) + 1));
                        i = 0;
                    } else
                        i = 1;
                }
            }


        }




        if(seed.get(seedOrder) == 1){
            Intent intent = new Intent(StartGame.this, Questionnaire.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 2){
            Intent intent = new Intent(StartGame.this, Questionnaire1.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 3){
            Intent intent = new Intent(StartGame.this, Questionnaire2.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 4){
            Intent intent = new Intent(StartGame.this, Questionnaire3.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }
/*


        Intent intent = new Intent(StartGame.this, Questionnaire.class);
        intent.putExtra("runningScore", baseScore);
        intent.putExtra("seedOrder",seedOrder + 1);
        intent.putIntegerArrayListExtra("seed",seed);
        startActivity(intent);
*/

    }


    public void howToPlay(View view) {


        Intent intent = new Intent(StartGame.this, HowToPlay.class);
        startActivity(intent);

    }

    public void leaderBoards(View view) {
        Intent intent = new Intent(StartGame.this,Leaderboards.class);
        startActivity(intent);
    }
}