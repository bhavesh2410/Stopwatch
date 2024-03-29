package com.example.stopwatch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.TextureView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int seconds=0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null)
        {
            seconds=savedInstanceState.getInt("seconds");
            running=savedInstanceState.getBoolean("running");
        }
        runTimer();
    }

    public void onSavedInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
    }

   public void onClickStart(View view){
        running=true;
   }
   public void onClickStop(View view){
        running=false;
   }

   public void onClickReset(View view){
        running=false;
        seconds=0;
   }
   public void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.time_view);

        final Handler handler= new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs=seconds%60;
               // int milisecs=(seconds%1000)/60;

                String time= String.format("%02d:%02d:%02d",hours,minutes,secs);
                timeView.setText(time);

                if(running)
                {
                    seconds++;

                }

                handler.postDelayed(this,0000);
            }
        });




   }
}
