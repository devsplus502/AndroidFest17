package com.plus502.afest.afestguate;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mHandler = new Handler();
        mHandler.postDelayed(aFestRunnable, 6_000);
    }

    Runnable aFestRunnable = new Runnable() {
        @Override
        public void run() {
            goToMain();
        }
    };

    private void goToMain(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
