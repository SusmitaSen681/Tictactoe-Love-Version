package com.example.tictactoeloveversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
   private Button buttonplay;
    Animation scaleu, scaled;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }


    public void player(View view) {
        buttonplay = findViewById(R.id.play);
        scaleu = AnimationUtils.loadAnimation(this, R.anim.scaleup);
        scaled = AnimationUtils.loadAnimation(this, R.anim.scaledown);
        buttonplay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    buttonplay.startAnimation(scaleu);

                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    buttonplay.startAnimation(scaled);
                }
                return true;
            }
        });

       EditText playern=findViewById(R.id.name);
       EditText playername=findViewById(R.id.names);
        String fnane=playern.getText().toString();
        String sname=playername.getText().toString();
        Intent intent=new Intent(login.this,tic.class);
        intent.putExtra("NAME",fnane);
        intent.putExtra("NAMES",sname);
        startActivity(intent);
    }
}


