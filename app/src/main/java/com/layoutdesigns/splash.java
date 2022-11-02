package com.layoutdesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Objects;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
// getSupportActionBar().setTitle("Humblebean1312");// put this here for display title ;
       // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.brown1)));//for background color in action barb
        getWindow().setFlags(//actionbar hide/show codes
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, //no color differentiation in actionbar and rest screen
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        Objects.requireNonNull(getSupportActionBar()).hide();//here .show= actionbar shown

        Thread thread=new Thread(){// multiple function running like

            public void run(){

                try {
                    sleep(3000);

                }
                catch (Exception e){
                    e.printStackTrace();

                }
                finally {
                    Intent intent = new Intent(splash.this , sign.class);
                    startActivity(intent);

                }
            }
        }; thread.start();
    }
}