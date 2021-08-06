package com.example.lab4b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import static java.lang.Thread.sleep;

public class MainActivity extends Activity {
    private Socket socket;
    private static final int SERVERPORT = 6000;
    private static final String SERVER_IP = "192.168.1.53";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        new Thread(new ClientThread()).start();
    }
    public void Rondomize(View view) {
        try {
            EditText et1 = (EditText) findViewById(R.id.Text1);
            EditText et2 = (EditText) findViewById(R.id.Text2);
            EditText et3 = (EditText) findViewById(R.id.Text3);
            String str1 = et1.getText().toString();
            String str2 = et2.getText().toString();
            String str3 = et3.getText().toString();
            String str = str1 + " " + str2 + " " + str3;
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())),
                    true);
            out.println(str);
            sleep(20);
            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            System.out.println(stdIn);
            String results = stdIn.readLine();
            TextView displayResult = (TextView)
                    findViewById(R.id.displayResult);
            displayResult.setText(results);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class ClientThread implements Runnable {
        @Override
        public void run() {
            try {
                InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
                socket = new Socket(serverAddr, SERVERPORT);
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}