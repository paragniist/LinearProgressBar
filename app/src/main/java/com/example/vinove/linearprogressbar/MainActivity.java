package com.example.vinove.linearprogressbar;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

/*
* //Theory of Progress Bar
*
* Linear
* =======
*
* 4types
*
* 1. Determinate  // percentage
* 2. Indeterminate
* 3. Buffer
* 4. Query Indeterminate and Determinate
*
* Circular
* ========
* 1. Determinate
* 2. Indeterminate
*
* */

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Handler handler;
    Runnable runnable;
    Timer timer;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar = (ProgressBar) findViewById(R.id.progressBar_id);
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0); //initial value for progress bar
        progressBar.setSecondaryProgress(0);
        progressBar.setMax(100); // this is maximum value

        //now i am going to make my ProgressBar change it value incrementally

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {// it took 8sec before our task started
/*                timer.cancel();
                //   progressBar.setVisibility(View.GONE);*/
                if (++i <= 100) { // it means that every 1 sec i will b incremented by 1

                    progressBar.setProgress(i);
                    progressBar.setSecondaryProgress(i + 10);

                } else {

                    timer.cancel();
                    progressBar.setVisibility(View.GONE);

                }

            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                handler.post(runnable);
            }
        }, 2000, 300);
    }
}
