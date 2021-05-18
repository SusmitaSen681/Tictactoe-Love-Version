package com.example.tictactoeloveversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class tic extends AppCompatActivity {

private  Button rest;
private  TextView com;
Animation scal,scale;
    boolean gameActive = true;



    int activePlayer = 0;
    int[] gameState = {2, 2 , 2, 2, 2, 2, 2, 2, 2};

    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};
    public static int counter = 0;

    public void tap(View view) {
        Intent intent = getIntent();
        String fname = intent.getStringExtra("NAME");
        String sname = intent.getStringExtra("NAMES");
        com = findViewById(R.id.command);


        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if (!gameActive ) {
            gameReset(view);
        }
        if (gameState[tappedImage] == 2) {
            

            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);

            if (activePlayer == 0) {
                img.setImageResource(R.drawable.cross);
                activePlayer = 1;

//                TextView status = findViewById(R.id.command);
                // status.setText("O's Turn - Tap to play");
                com.setText((sname + " 's Turn-Tap to play"));
            } else {
                img.setImageResource(R.drawable.haha);
                activePlayer = 0;
//                TextView status = findViewById(R.id.command);
                //status.setText("X's Turn - Tap to play");
                com.setText((fname + "'s Turn-Tap to play"));
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
         int flag = 0;
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2) {
                flag = 1;
                com = findViewById(R.id.command);
//                String playern= getIntent().getStringExtra("Player_names");
//                String playername= getIntent().getStringExtra("Player_name");

//                String winnerStr;
                gameActive = false;
                if (gameState[winPosition[0]] == 0) {
//                    winnerStr = "X has won";
                    com.setText((fname + " is Winner"));
                } else {
//                    winnerStr = "O has won";
                    com.setText((sname + " is Winner"));
                }


//                TextView status = findViewById(R.id.command);
//                status.setText(winnerStr);

            }

        }
        if(counter==9 && flag==0)
        {
            com=findViewById(R.id.command);
            com.setText(("Oops!!Match Draw"));
            gameActive=false;
        }
    }

    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for(int i=0; i<gameState.length; i++){
            gameState[i] = 2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


        com = findViewById(R.id.command);
        Intent intent=getIntent();
        String fname= intent.getStringExtra("NAME");
       com.setText((fname+" 's Turn-Tap to play"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic);
       rest=findViewById(R.id.restarting);
       com=findViewById(R.id.command);





    }

    public void dude(View view) {
        scal = AnimationUtils.loadAnimation(this, R.anim.scaleup);
        scale = AnimationUtils.loadAnimation(this, R.anim.scaledown);
        rest=findViewById(R.id.restarting);
        rest.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    rest.startAnimation(scal);

                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    rest.startAnimation(scale);
                }
                return true;
            }
        });
        Intent intent=new Intent(tic.this,login.class);
        startActivity(intent);
    }
}