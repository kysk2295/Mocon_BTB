package com.kys.lg.mocon_btb;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashAcitivity extends AppCompatActivity {
    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_acitivity);


        Handler handler= new Handler();
        handler.postDelayed(new Splash(),3000);
    }


    private class Splash implements Runnable {
        @Override
        public void run() {

            Intent i = new Intent(SplashAcitivity.this,LoginActivity.class);
            startActivity(i);
            finish();
        }
    }
}
