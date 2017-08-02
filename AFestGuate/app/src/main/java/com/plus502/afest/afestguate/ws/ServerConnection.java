package com.plus502.afest.afestguate.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mercedeswyss on 15/07/17.
 */

public class ServerConnection {

    private static final String SERVER_URL =
        "http://54.174.33.86:7500/speakers";

    public static String connectToServer(){
        String result = null;

        try {
            URL url =  new URL(SERVER_URL);
            HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

            connection.setConnectTimeout(10_000);
            connection.setReadTimeout(15_000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type","application/json");

            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));

                    result = "";
                    String temp;
                    while((temp = bufferedReader.readLine()) != null){
                        result += temp;
                    }
            }else{
                result = "Se presento el error: "
                        + responseCode;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
