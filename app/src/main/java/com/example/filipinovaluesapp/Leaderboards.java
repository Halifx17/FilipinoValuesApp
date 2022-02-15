package com.example.filipinovaluesapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Leaderboards extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference dbReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards);

        mAuth=FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        dbReference = FirebaseDatabase.getInstance().getReference("Users");


        dbReference.orderByChild("score").limitToLast(10).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                Highscore user_score = snapshot.getValue(Highscore.class);
                System.out.println(snapshot.getKey()+" "+user_score.username+" Score is "+user_score.score);
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






    }


    public void cancelButton(View view) {
        Intent intent = new Intent(Leaderboards.this,StartGame.class);
        startActivity(intent);
    }
}