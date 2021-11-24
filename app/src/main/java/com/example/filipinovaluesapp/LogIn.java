package com.example.filipinovaluesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {

    EditText editEmail, editPassword;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        editEmail = findViewById(R.id.LogIn_Edit_Email);
        editPassword = findViewById(R.id.LogIn_Edit_Password);

        mAuth = FirebaseAuth.getInstance();
    }

    public void registerButton(View view) {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void LogIn(View view) {

        String email, password;
        email = editEmail.getText().toString().trim();
        password = editPassword.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            Toast.makeText(LogIn.this, "Log In Successful", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), Introduction.class);
                            startActivity(intent);

                        }else{
                            Toast.makeText(LogIn.this, "Email or Password is incorrect", Toast.LENGTH_LONG).show();
                        }

                    }
                });


    }


    public void guestButton(View view) {
        mAuth.signInAnonymously().addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LogIn.this, "Signed In as Guest", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), Introduction.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LogIn.this, "Error Guest Sign In", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}