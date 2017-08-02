package com.plus502.afest.afestguate;

import android.content.ServiceConnection;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.plus502.afest.afestguate.ws.ServerConnection;

public class MainActivity extends AppCompatActivity {

    private TextView tvResponse;
    private String serverResult = "Nada";

    private Handler mHandler;
    private Boolean ready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResponse = (TextView)
                findViewById(R.id.tv_response);

        mHandler = new Handler();
    }

    public void getSpeakers(View view){
        new Thread(){
            @Override
            public void run(){
                ready = false;
                serverResult =
                    ServerConnection.connectToServer();
                ready = true;
            }
        }.start();

        mHandler.postDelayed(checkRunnable, 1_000);
    }

    Runnable checkRunnable = new Runnable() {
        @Override
        public void run() {
            if(ready){
                showResult();
            }else{
                mHandler.postDelayed(checkRunnable, 500);
            }
        }
    };

    private void showResult(){
        tvResponse.setText(serverResult);
    }
}
