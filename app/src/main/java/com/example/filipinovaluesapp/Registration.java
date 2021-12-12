package com.example.filipinovaluesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    EditText editUserName, editEmail, editPassword, editRetypePassword;
    TextInputLayout editTextUser, editTextEmail, editTextPassword, editTextRetypePassword;
    FirebaseAuth mAuth;
    Button regregButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editUserName = findViewById(R.id.Edit_Username);
        editEmail = findViewById(R.id.Edit_Email);
        editPassword = findViewById(R.id.Edit_Password);
        editRetypePassword = findViewById(R.id.Edit_RetypePassword);
        editTextUser = (TextInputLayout) findViewById(R.id.EditText_Username);
        editTextEmail = (TextInputLayout) findViewById(R.id.EditText_Email);
        editTextPassword = (TextInputLayout) findViewById(R.id.EditText_Password);
        editTextRetypePassword = (TextInputLayout) findViewById(R.id.EditText_RetypePassword);
        regregButton = findViewById(R.id.regregbutton);






        mAuth = FirebaseAuth.getInstance();

        regregButton.setOnTouchListener(new View.OnTouchListener() {
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


    public void registerFirebase(View view) {

        String username, email, password, retypePassword;

        username = editUserName.getText().toString().trim();
        email = editEmail.getText().toString().trim();
        password = editPassword.getText().toString().trim();
        retypePassword = editRetypePassword.getText().toString().trim();

        if(username.isEmpty()&&email.isEmpty()&&password.isEmpty()){
            Toast.makeText(Registration.this, "Fields are Required", Toast.LENGTH_LONG).show();
            editTextUser.setError("Username is Required\nMaximum of 8 characters");
            editTextEmail.setError("Email is Required");
            editTextPassword.setError("Password is Required\nMinimum of 6 characters");
        }
        else if(username.isEmpty()){
            Toast.makeText(Registration.this, "Username is Required", Toast.LENGTH_LONG).show();
            editTextUser.setError("Username is Required");
            editTextEmail.setError(null);
            editTextPassword.setError(null);
            editTextRetypePassword.setError(null);
        }else if(email.isEmpty()){
            Toast.makeText(Registration.this, "Email is Required", Toast.LENGTH_LONG).show();
            editTextEmail.setError("Email is Required");
            editTextUser.setError(null);
            editTextPassword.setError(null);
            editTextRetypePassword.setError(null);
        }else if(password.isEmpty()){
            Toast.makeText(Registration.this, "Password is Required", Toast.LENGTH_LONG).show();
            editTextPassword.setError("Password is Required\nMinimum of 6 characters");
            editTextUser.setError(null);
            editTextEmail.setError(null);
            editTextRetypePassword.setError(null);
        }

        else if(!password.equals(retypePassword)){
            Toast.makeText(Registration.this, "Password Does not match", Toast.LENGTH_LONG).show();
            editTextRetypePassword.setError("Does not match");
            editTextUser.setError(null);
            editTextEmail.setError(null);
            editTextPassword.setError(null);

        }else {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                User user = new User(username, email, password);

                                FirebaseDatabase.getInstance().getReference("Users")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        if (task.isSuccessful()) {
                                            openDialog();
                                        } else {
                                            Toast.makeText(Registration.this, "Failed Registration", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(Registration.this, "Failed to register", Toast.LENGTH_LONG).show();
                            }

                        }
                    });


        }

    }

    public void openDialog(){

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
        builder.setTitle("Success");
        builder.setMessage("Registration Successful");
        builder.setPositiveButton("Log In", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(getApplicationContext(),LogIn.class);
                startActivity(intent);

            }
        });

        builder.show();

    }


}