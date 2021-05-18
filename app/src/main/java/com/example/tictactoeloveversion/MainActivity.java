package com.example.tictactoeloveversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH = 5000;
    Animation topanim, bottomanim, middleanim;

    TextView text, texts, textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        topanim = AnimationUtils.loadAnimation(this, R.anim.top);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom);
        middleanim = AnimationUtils.loadAnimation(this, R.anim.middle);

        texts = findViewById(R.id.textView2);
        text = findViewById(R.id.textView);
        textView = findViewById(R.id.textView3);

        texts.setAnimation(topanim);
        textView.setAnimation(bottomanim);
        text.setAnimation(middleanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH);
    }
}