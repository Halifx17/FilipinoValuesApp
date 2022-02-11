package com.example.filipinovaluesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {

    EditText editEmail, editPassword;
    TextView guest, register;
    TextInputLayout editTextEmail, editTextPassword;
    FirebaseAuth mAuth;
    Button LogInButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        editEmail = findViewById(R.id.LogIn_Edit_Email);
        editPassword = findViewById(R.id.LogIn_Edit_Password);
        editTextEmail = (TextInputLayout) findViewById(R.id.EditText_Email);
        editTextPassword = (TextInputLayout) findViewById(R.id.EditText_Password);
        LogInButton = findViewById(R.id.LogInButton);

        mAuth = FirebaseAuth.getInstance();

        guest = (TextView) findViewById(R.id.guest);
        register = (TextView) findViewById(R.id.register);

        guest.setOnTouchListener(new View.OnTouchListener() {
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

        register.setOnTouchListener(new View.OnTouchListener() {
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




        LogInButton.setOnTouchListener(new View.OnTouchListener() {
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

        if(email.isEmpty()&&password.isEmpty()){

            Toast.makeText(LogIn.this, "Fields cannot be Empty", Toast.LENGTH_SHORT).show();
            editTextEmail.setError("Email is required");
            editTextPassword.setError("Password is required");

        }
        else if(email.isEmpty()){
            Toast.makeText(LogIn.this, "Email cannot be Empty", Toast.LENGTH_SHORT).show();
            editTextEmail.setError("Password is required");
            editTextPassword.setError(null);



        }

        else if(password.isEmpty()){
            Toast.makeText(LogIn.this, "Password cannot be Empty", Toast.LENGTH_SHORT).show();
            editTextPassword.setError("Password is required");
            editTextEmail.setError(null);

        }

        else{
            editTextEmail.setError(null);
            editTextPassword.setError(null);


            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){

                                Toast.makeText(LogIn.this, "Log In Successful", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), StartGame.class);
                                startActivity(intent);

                            }else{
                                Toast.makeText(LogIn.this, "Email or Password is incorrect", Toast.LENGTH_LONG).show();
                            }

                        }
                    });
        }




    }


    public void guestButton(View view) {
        mAuth.signInAnonymously().addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(LogIn.this, "Signed In as Guest", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), StartGame.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LogIn.this, "Error Guest Sign In", Toast.LENGTH_LONG).show();
                }

            }
        });
    }


}