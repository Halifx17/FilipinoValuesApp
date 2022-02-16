package com.example.filipinovaluesapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboards extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference dbReference;
    TextView firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace;
    TextView firstPlaceName, secondPlaceName, thirdPlaceName, fourthPlaceName, fifthPlaceName;

    String firstPlaceExtra, secondPlaceExtra, thirdPlaceExtra, fourthPlaceExtra, fifthPlaceExtra;
    String firstPlaceNameExtra, secondPlaceNameExtra, thirdPlaceNameExtra, fourthPlaceNameExtra, fifthPlaceNameExtra;

    ArrayList<String> usernames = new ArrayList<>();
    ArrayList <Integer>scores = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards);

        firstPlace = findViewById(R.id.firstPlace);
        secondPlace = findViewById(R.id.secondPlace);
        thirdPlace = findViewById(R.id.thirdPlace);
        fourthPlace = findViewById(R.id.fourthPlace);
        fifthPlace = findViewById(R.id.fifthPlace);

        firstPlaceName = findViewById(R.id.firstPlaceName);
        secondPlaceName = findViewById(R.id.secondPlaceName);
        thirdPlaceName = findViewById(R.id.thirdPlaceName);
        fourthPlaceName = findViewById(R.id.fourthPlaceName);
        fifthPlaceName = findViewById(R.id.fifthPlaceName);

        mAuth=FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        dbReference = FirebaseDatabase.getInstance().getReference("Users");

        firstPlaceExtra = getIntent().getStringExtra("firstScore");
        secondPlaceExtra = getIntent().getStringExtra("secondScore");
        thirdPlaceExtra = getIntent().getStringExtra("thirdScore");
        fourthPlaceExtra = getIntent().getStringExtra("fourthScore");
        fifthPlaceExtra = getIntent().getStringExtra("fifthScore");

        firstPlaceNameExtra = getIntent().getStringExtra("firstName");
        secondPlaceNameExtra = getIntent().getStringExtra("secondName");
        thirdPlaceNameExtra = getIntent().getStringExtra("thirdName");
        fourthPlaceNameExtra = getIntent().getStringExtra("fourthName");
        fifthPlaceNameExtra = getIntent().getStringExtra("fifthName");

        firstPlace.setText(firstPlaceExtra);
        secondPlace.setText(secondPlaceExtra);
        thirdPlace.setText(thirdPlaceExtra);
        fourthPlace.setText(fourthPlaceExtra);
        fifthPlace.setText(fifthPlaceExtra);

        firstPlaceName.setText(firstPlaceNameExtra);
        secondPlaceName.setText(secondPlaceNameExtra);
        thirdPlaceName.setText(thirdPlaceNameExtra);
        fourthPlaceName.setText(fourthPlaceNameExtra);
        fifthPlaceName.setText(fifthPlaceNameExtra);


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
                    Log.d("test",score.username+" Score is " + score.score);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



/*
        dbReference.orderByChild("score").limitToLast(10).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Highscore user_score = snapshot.getValue(Highscore.class);



                System.out.println(snapshot.getKey() + " " + user_score.username + " Score is " + user_score.score);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



*/


/*

            dbReference.orderByChild("score").limitToLast(2).addChildEventListener(new ChildEventListener() {


                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    Highscore user_score = snapshot.getValue(Highscore.class);
                    firstPlace.setText(user_score.username);
                    System.out.println(snapshot.getKey() + " " + user_score.username + " Score is " + user_score.score);

                }


                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }

            });



*/



    }




    public void cancelButton(View view) {
        Intent intent = new Intent(Leaderboards.this,StartGame.class);
        startActivity(intent);
    }



    public void show(View view) {

        for(int i = scores.size()-1; i>=0; i--){
            if(i == scores.size()-1){
                firstPlace.setText(Integer.toString(scores.get(i)));
            }else if(i == scores.size()-2){
                secondPlace.setText(Integer.toString(scores.get(i)));
            }else if(i == scores.size()-3){
                thirdPlace.setText(Integer.toString(scores.get(i)));
            }else if(i == scores.size()-4){
                fourthPlace.setText(Integer.toString(scores.get(i)));
            }else if(i == scores.size()-5){
                fifthPlace.setText(Integer.toString(scores.get(i)));
            }
        System.out.println(scores.get(i));
        }
        for(int i = 0; i<=usernames.size()-1; i++){
            if(i == usernames.size()-1){
                firstPlaceName.setText(usernames.get(i));
            }else if(i == usernames.size()-2){
                secondPlaceName.setText(usernames.get(i));
            }else if(i == usernames.size()-3){
                thirdPlaceName.setText(usernames.get(i));
            }else if(i == usernames.size()-4){
                fourthPlaceName.setText(usernames.get(i));
            }else if(i == usernames.size()-5){
                fifthPlaceName.setText(usernames.get(i));
            }
            System.out.println(usernames.get(i));
        }
    }
}