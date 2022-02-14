package com.example.filipinovaluesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Settings extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference dbReference;

    String userID;
    String userExtra;
    String emailExtra;
    int highScoreExtra;
    TextView txtUser, txtEmail, txtHighScore;
    Button settingsReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        mAuth=FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        dbReference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        settingsReg = findViewById(R.id.settingReg);

        txtUser = findViewById(R.id.username);
        txtEmail = findViewById(R.id.email);
        txtHighScore = findViewById(R.id.highScore);


        userExtra = getIntent().getStringExtra("username");
        emailExtra = getIntent().getStringExtra("email");
        highScoreExtra = getIntent().getIntExtra("highScore",0);

        if(userExtra!=null) {

            settingsReg.setVisibility(View.INVISIBLE);
            txtUser.setText(userExtra);
            txtEmail.setText(emailExtra);
            txtHighScore.setText(Integer.toString(highScoreExtra));
        }









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




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }



    public void cancelButton(View view) {
        Intent intent = new Intent(Settings.this,StartGame.class);
        startActivity(intent);
        }

    public void logout(View view) {

        mAuth.signOut();
        Intent intent = new Intent(Settings.this,three_in_one.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void settingsReg(View view) {
        Intent intent = new Intent(Settings.this,three_in_one.class);
        startActivity(intent);
    }
}
