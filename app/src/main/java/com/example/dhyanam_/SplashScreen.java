package com.example.dhyanam_;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;


import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;





public class SplashScreen extends AppCompatActivity {


    private static int SPLASH_SCREEN = 3000;
    //Variables
    Animation topAnim, bottonAnim;
    ImageView image;
    TextView logo, slogan;

    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottonAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.imageView2);
        logo = findViewById(R.id.textView3);
        slogan = findViewById(R.id.textView4);

        image.setAnimation(topAnim);
        logo.setAnimation(bottonAnim);
        slogan.setAnimation(bottonAnim);


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
//
//                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);
//
//                if (isFirstTime) {
//
//                    SharedPreferences.Editor editor = onBoardingScreen.edit();
//                    editor.putBoolean("firstTime", false);
//                    editor.apply();
//
//                    Intent intent = new Intent(SplashScreen.this, OnBoardingScreen.class);
//                    startActivity(intent);
//                } else {
//                    Intent intent = new Intent(SplashScreen.this, OnBoardingScreen.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }
//        }, SPLASH_SCREEN);


        new Handler(Looper.myLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);
                if (isFirstTime) {
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime", false);
                    editor.apply();
                    Intent intent = new Intent(SplashScreen.this, OnBoardingScreen.class);
                    startActivity(intent);

                } else {

                    Intent intent = new Intent(SplashScreen.this, OnBoardingScreen.class);
                    startActivity(intent);
                    finish();
                }
            }


        }, SPLASH_SCREEN);


//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent=new Intent(SplashScreen.this,OnBoardingScreen.class);
//                startActivity(intent);
//            }
//        },3000);




    }


}