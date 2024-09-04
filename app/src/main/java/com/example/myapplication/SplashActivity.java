package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize the ImageView or any other view you want to animate
        ImageView logo = findViewById(R.id.logoImageView);

        // Load the fade-in animation
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Start the animation
        logo.startAnimation(fadeIn);

        // Delay for 3 seconds before starting the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SenderFormActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
