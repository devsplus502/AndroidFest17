package com.plus502.afest.afestxela;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        handler = new Handler();
        handler.postDelayed(myRunnable, 2_000);
    }

    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            startOtherActivity();
        }
    };

    private void startOtherActivity(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
