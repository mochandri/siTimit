package com.example.sitimit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Splash extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//
//        final int welcomeScreenDisplay = 3000;
//        Thread welcomeThread = new Thread(){
//            int wait = 0;
//            @Override
//            public void run(){
//                try {
//                    super.run();
//                    while (wait < welcomeScreenDisplay){
//                        sleep(500);
//                        wait += 500;
//                    }
//                }catch (Exception e){
//                    System.out.println("EXc="+e);
//                }finally {
//                    Intent intent = new Intent(Splash.this, MainActivity.class );
//                    finish();
//                    startActivity(intent);
//                }
//            }
//        };
//        welcomeThread.start();

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        },5000L);
    }
}
