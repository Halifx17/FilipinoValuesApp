package com.example.filipinovaluesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class three_in_one extends AppCompatActivity {


    FirebaseAuth mAuth;
    Button LogIn, guestButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_in_one);

        mAuth = FirebaseAuth.getInstance();
        LogIn = findViewById(R.id.tioLogInButton);
        guestButton = findViewById(R.id.guestButton);
        registerButton = findViewById(R.id.regButton);



        LogIn.setOnTouchListener(new View.OnTouchListener() {
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

        registerButton.setOnTouchListener(new View.OnTouchListener() {
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

        guestButton.setOnTouchListener(new View.OnTouchListener() {
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

    public void tioGuestButton(View view) {
        mAuth.signInAnonymously().addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(three_in_one.this, "Signed In as Guest", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), StartGame.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(three_in_one.this, "Error Guest Sign In", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(three_in_one.this);

        builder.setMessage("Quit Game?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                System.exit(0);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();

    }

    public void tioLogIn(View view) {

        Intent intent = new Intent(three_in_one.this,LogIn.class);
        startActivity(intent);

    }


    public void tioRegister(View view) {
        Intent intent = new Intent(three_in_one.this,Registration.class);
        startActivity(intent);
    }
}