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

        // Load the slide-in-from-bottom animation
        Animation slideInBottom = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom);

        // Start the animation
        logo.startAnimation(slideInBottom);

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
