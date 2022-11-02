package com.layoutdesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;

public class payy extends AppCompatActivity {
    private CheckBox check,check1,check2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payy);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.brown1)));
        getSupportActionBar().setTitle("Payment Type");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getSupportActionBar().show();

        check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button popUpClass = new Button();
                popUpClass.showPopupWindow(v);
            }
        });

        check1 = findViewById(R.id.check1);
        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button popUpClass = new Button();
                popUpClass.showPopupWindow(v);
            }
        });

        check2 = findViewById(R.id.check2);
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button popUpClass = new Button();
                popUpClass.showPopupWindow(v);
            }
        });

    }
}