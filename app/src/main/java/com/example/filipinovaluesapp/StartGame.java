package com.example.filipinovaluesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StartGame extends AppCompatActivity {


    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference dbReference;
    String userID, userName, emailText, highScore;

    ArrayList<String> usernames = new ArrayList<>();
    ArrayList <Integer>scores = new ArrayList<>();

    String firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace;
    String firstPlaceName, secondPlaceName, thirdPlaceName, fourthPlaceName, fifthPlaceName;

    Button startGame, howToPlay, leaderBoards;
    int baseScore = 1000000, seedOrder = 0, points = 0;

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

        howToPlay.setVisibility(View.INVISIBLE);



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

        Query query = dbReference.orderByChild("score").limitToLast(5);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Highscore score=postSnapshot.getValue(Highscore.class);

                    if(score!=null){
                        scores.add(score.score);
                        usernames.add(score.username);
                    }

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

    @Override
    public void onBackPressed() {

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(StartGame.this);


        builder.setMessage("Return to LOG IN Screen?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(StartGame.this, three_in_one.class);
                mAuth.signOut();
                finish();
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

    public void settingsButton(View view) {
        Intent intent = new Intent(this, Settings.class);
        intent.putExtra("username",userName);
        intent.putExtra("email",emailText);
        intent.putExtra("highScore", highScore);

        startActivity(intent);





    }

    public void gameStart(View view) {
        ArrayList<Integer> seed = new ArrayList<Integer>();

        for (int count = 0; count <= 9; count++) {
            seed.add(count, (int) Math.floor((Math.random() * 10) + 1));
            int i = 0;
            while (i != 1 && seed.size() >= 2 && seed.size() <= 10) {
                if (seed.size() == 2) {
                    if (seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 10) + 1));
                        i = 0;
                    } else {
                        i = 1;
                    }

                } else if (seed.size() == 3) {
                    if (seed.get(count) == seed.get(count - 2)
                            ||seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 10) + 1));
                        i = 0;
                    } else
                        i = 1;
                } else if (seed.size() == 4) {
                    if (seed.get(count) == seed.get(count - 3)
                            ||seed.get(count) == seed.get(count - 2)
                            ||seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 10) + 1));
                        i = 0;
                    } else
                        i = 1;
                }else if (seed.size() == 5) {
                    if (seed.get(count) == seed.get(count - 4)
                            ||seed.get(count) == seed.get(count - 3)
                            ||seed.get(count) == seed.get(count - 2)
                            ||seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 10) + 1));
                        i = 0;
                    } else
                        i = 1;
                }else if (seed.size() == 6) {
                    if (seed.get(count) == seed.get(count - 5)
                            ||seed.get(count) == seed.get(count - 4)
                            ||seed.get(count) == seed.get(count - 3)
                            ||seed.get(count) == seed.get(count - 2)
                            ||seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 10) + 1));
                        i = 0;
                    } else
                        i = 1;
                }else if (seed.size() == 7) {
                    if (seed.get(count) == seed.get(count - 6)
                            ||seed.get(count) == seed.get(count - 5)
                            ||seed.get(count) == seed.get(count - 4)
                            ||seed.get(count) == seed.get(count - 3)
                            ||seed.get(count) == seed.get(count - 2)
                            ||seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 10) + 1));
                        i = 0;
                    } else
                        i = 1;
                }else if (seed.size() == 8) {
                    if (seed.get(count) == seed.get(count - 7)
                            ||seed.get(count) == seed.get(count - 6)
                            ||seed.get(count) == seed.get(count - 5)
                            ||seed.get(count) == seed.get(count - 4)
                            ||seed.get(count) == seed.get(count - 3)
                            ||seed.get(count) == seed.get(count - 2)
                            ||seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 10) + 1));
                        i = 0;
                    } else
                        i = 1;
                }else if (seed.size() == 9) {
                    if (seed.get(count) == seed.get(count - 8)
                            ||seed.get(count) == seed.get(count - 7)
                            ||seed.get(count) == seed.get(count - 6)
                            ||seed.get(count) == seed.get(count - 5)
                            ||seed.get(count) == seed.get(count - 4)
                            ||seed.get(count) == seed.get(count - 3)
                            ||seed.get(count) == seed.get(count - 2)
                            ||seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 10) + 1));
                        i = 0;
                    } else
                        i = 1;
                }else if (seed.size() == 10) {
                    if (seed.get(count) == seed.get(count - 9)
                            ||seed.get(count) == seed.get(count - 8)
                            ||seed.get(count) == seed.get(count - 7)
                            ||seed.get(count) == seed.get(count - 6)
                            ||seed.get(count) == seed.get(count - 5)
                            ||seed.get(count) == seed.get(count - 4)
                            ||seed.get(count) == seed.get(count - 3)
                            ||seed.get(count) == seed.get(count - 2)
                            ||seed.get(count) == seed.get(count - 1)) {
                        seed.set(count, (int) Math.floor((Math.random() * 10) + 1));
                        i = 0;
                    } else
                        i = 1;
                }


            }



        }




        if(seed.get(seedOrder) == 1){
            Intent intent = new Intent(StartGame.this, Questionnaire.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("points",points);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 2){
            Intent intent = new Intent(StartGame.this, Questionnaire1.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("points", points);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 3){
            Intent intent = new Intent(StartGame.this, Questionnaire2.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("points", points);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 4){
            Intent intent = new Intent(StartGame.this, Questionnaire3.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("points", points);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 5){
            Intent intent = new Intent(StartGame.this, Questionnaire4.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("points", points);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 6){
            Intent intent = new Intent(StartGame.this, Questionnaire5.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("points", points);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 7){
            Intent intent = new Intent(StartGame.this, Questionnaire6.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("points", points);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 8){
            Intent intent = new Intent(StartGame.this, Questionnaire7.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("points", points);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 9){
            Intent intent = new Intent(StartGame.this, Questionnaire8.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("points", points);
            intent.putExtra("seedOrder",seedOrder + 1);
            intent.putIntegerArrayListExtra("seed",seed);
            startActivity(intent);
        }else if(seed.get(seedOrder) == 10){
            Intent intent = new Intent(StartGame.this, Questionnaire9.class);
            intent.putExtra("runningScore", baseScore);
            intent.putExtra("points", points);
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
        for(int x = 0; x<=9; x++){
            System.out.println(seed.get(x));
        }

    }


    public void howToPlay(View view) {


        Intent intent = new Intent(StartGame.this, HowToPlay.class);
        startActivity(intent);

    }

    public void leaderBoards(View view) {

        Intent intent = new Intent(StartGame.this,Leaderboards.class);

        for(int i = scores.size()-1; i>=0; i--){
            if(i == scores.size()-1){
                firstPlace = Integer.toString(scores.get(i));
            }else if(i == scores.size()-2){
                secondPlace = Integer.toString(scores.get(i));
            }else if(i == scores.size()-3){
                thirdPlace = Integer.toString(scores.get(i));
            }else if(i == scores.size()-4){
                fourthPlace = Integer.toString(scores.get(i));
            }else if(i == scores.size()-5){
                fifthPlace = Integer.toString(scores.get(i));
            }
            System.out.println(scores.get(i));
        }
        for(int i = 0; i<=usernames.size()-1; i++){
            if(i == usernames.size()-1){
                firstPlaceName = usernames.get(i);
            }else if(i == usernames.size()-2){
                secondPlaceName = usernames.get(i);
            }else if(i == usernames.size()-3){
                thirdPlaceName = usernames.get(i);
            }else if(i == usernames.size()-4){
                fourthPlaceName = usernames.get(i);
            }else if(i == usernames.size()-5){
                fifthPlaceName = usernames.get(i);
            }
            System.out.println(usernames.get(i));
        }

        intent.putExtra("firstScore", firstPlace);
        intent.putExtra("secondScore", secondPlace);
        intent.putExtra("thirdScore", thirdPlace);
        intent.putExtra("fourthScore", fourthPlace);
        intent.putExtra("fifthScore", fifthPlace);

        intent.putExtra("firstName", firstPlaceName);
        intent.putExtra("secondName", secondPlaceName);
        intent.putExtra("thirdName", thirdPlaceName);
        intent.putExtra("fourthName", fourthPlaceName);
        intent.putExtra("fifthName", fifthPlaceName);
        startActivity(intent);
    }
}