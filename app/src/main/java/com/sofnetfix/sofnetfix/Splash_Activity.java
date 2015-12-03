package com.sofnetfix.sofnetfix;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash_Activity extends Activity {
    protected int Duracion_Splash = 10000;
    protected ProgressBar progreso;
    protected boolean active= true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);

        progreso = (ProgressBar) findViewById(R.id.progressBar);
        progreso.setMax(8);
        empezar();

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
          setSupportActionBar(toolbar);
        */
    }

    public void empezar(){
        new CountDownTimer(3500,1000){
            @Override
            public void onTick(long millisUtilFinished){
                progreso.setProgress(asignar_progreso(millisUtilFinished));
            }

            @Override
            public void onFinish(){
                Intent i = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }

        }.start();
    }

    public int asignar_progreso(long miliseconds){
        return(int) ((Duracion_Splash-miliseconds)/1000);

    }
    }
