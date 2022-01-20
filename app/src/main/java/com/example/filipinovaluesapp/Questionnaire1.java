package com.example.filipinovaluesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Questionnaire1 extends AppCompatActivity {

    Button choiceOne, choiceTwo, choiceThree, choiceFour, nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire1);

        nextButton = findViewById(R.id.nextButton);

        choiceOne = findViewById(R.id.Choice1);
        choiceTwo = findViewById(R.id.Choice2);
        choiceThree = findViewById(R.id.Choice3);
        choiceFour = findViewById(R.id.Choice4);

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

    public void clearSelection(){

        choiceOne.getBackground().setAlpha(255);
        choiceOne.setTextColor(Color.parseColor("#FFFFFFFF"));
        choiceTwo.getBackground().setAlpha(255);
        choiceTwo.setTextColor(Color.parseColor("#FFFFFFFF"));
        choiceThree.getBackground().setAlpha(255);
        choiceThree.setTextColor(Color.parseColor("#FFFFFFFF"));
        choiceFour.getBackground().setAlpha(255);
        choiceFour.setTextColor(Color.parseColor("#FFFFFFFF"));
    }

    public void settingsButton(View view) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }



    public void MCQ1(View view) {

        clearSelection();
        choiceTwo.getBackground().setAlpha(64);
        choiceTwo.setTextColor(Color.parseColor("#778899"));
        choiceThree.getBackground().setAlpha(64);
        choiceThree.setTextColor(Color.parseColor("#778899"));
        choiceFour.getBackground().setAlpha(64);
        choiceFour.setTextColor(Color.parseColor("#778899"));
    }

    public void MCQ2(View view) {

        clearSelection();

        choiceOne.getBackground().setAlpha(64);
        choiceOne.setTextColor(Color.parseColor("#778899"));
        choiceThree.getBackground().setAlpha(64);
        choiceThree.setTextColor(Color.parseColor("#778899"));
        choiceFour.getBackground().setAlpha(64);
        choiceFour.setTextColor(Color.parseColor("#778899"));

    }

    public void MCQ3(View view) {
        clearSelection();
        choiceOne.getBackground().setAlpha(64);
        choiceOne.setTextColor(Color.parseColor("#778899"));
        choiceTwo.getBackground().setAlpha(64);
        choiceTwo.setTextColor(Color.parseColor("#778899"));
        choiceFour.getBackground().setAlpha(64);
        choiceFour.setTextColor(Color.parseColor("#778899"));
    }

    public void MCQ4(View view) {
        clearSelection();
        choiceOne.getBackground().setAlpha(64);
        choiceOne.setTextColor(Color.parseColor("#778899"));
        choiceThree.getBackground().setAlpha(64);
        choiceThree.setTextColor(Color.parseColor("#778899"));
        choiceTwo.getBackground().setAlpha(64);
        choiceTwo.setTextColor(Color.parseColor("#778899"));
    }

    public void nextButton1(View view) {

        Intent intent = new Intent(Questionnaire1.this,Questionnaire2.class);
        startActivity(intent);
    }
}