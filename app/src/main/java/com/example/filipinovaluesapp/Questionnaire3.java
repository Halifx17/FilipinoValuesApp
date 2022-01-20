package com.example.filipinovaluesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Questionnaire3 extends AppCompatActivity {

    Button nextButton;
    EditText editAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire3);

        nextButton = findViewById(R.id.nextButton);
        editAnswer = findViewById(R.id.Edit_Answer);














        nextButton.setOnTouchListener(new View.OnTouchListener() {
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




    public void settingsButton(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

    public void nextButton1(View view) {

        Intent intent = new Intent(Questionnaire3.this,Questionnaire3.class);
        startActivity(intent);

        String answer;

        answer = editAnswer.getText().toString().trim();

        Toast.makeText(Questionnaire3.this,answer,Toast.LENGTH_SHORT).show();

    }


}