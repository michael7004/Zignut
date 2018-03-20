package com.zignut.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.zignut.R;

/**
 * Created by Lenovo on 17-03-2018.
 */

public class SplashActivity extends AppCompatActivity {

    private Handler handler;
    private final int TIME_INTERVAL = 3000;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        setHandler();
    }


    /**
     * Handler to start the Runnable Interface after the delay
     * of 3000 seconds
     */
    private void setHandler() {
        handler = new Handler();
        handler.postDelayed(runnable, TIME_INTERVAL);
    }


    /**
     * Starts a Runnable Interface to switch the Splash Screen
     * to Login Screen.
     */
    final Runnable runnable = new Runnable() {

        @Override
        public void run() {
            final Intent loginIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(loginIntent);
            overridePendingTransition(R.anim.activity_right_in, R.anim.activity_left_out);
            finish();

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // remove the runnable set with the Handler
        // if the Activity gets destroyed in any case
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
