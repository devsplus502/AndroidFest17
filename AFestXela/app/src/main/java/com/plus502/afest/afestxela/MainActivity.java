package com.plus502.afest.afestxela;

import android.content.ServiceConnection;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.plus502.afest.afestxela.ws.ServerConnection;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView tvRestfulWS;

    private Handler handler;
    private Boolean ready;
    private String jsonResult = "Pues nada!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRestfulWS = (TextView) findViewById(R.id.tv_result_ws);
        handler = new Handler();
    }

    public void pressButton(View view){
        Toast.makeText(this,
                "Vamos a consumir el servicio",
                Toast.LENGTH_LONG).show();

        thread.start();
        handler.postDelayed(verifieWS, 1_000);
    }

    private Thread thread =  new Thread(){
        @Override
        public void run(){
            ready = false;
            jsonResult = ServerConnection.connectToServer();
            ready = true;
        }
    };

    private Runnable verifieWS = new Runnable() {
        @Override
        public void run() {
            if (ready){
                showJsonResult();
            }else{
                handler.postDelayed(verifieWS, 1_000);
            }
        }
    };

    private void showJsonResult(){
        tvRestfulWS.setText(jsonResult);
    }

}
