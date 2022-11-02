package com.layoutdesigns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class page2 extends AppCompatActivity {
    private TextView text;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<customArrayAdapter> userList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        getSupportActionBar().setTitle("Humblebean1312");
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getSupportActionBar().hide();

        text = findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(page2.this, Offer.class);
                startActivity(intent);
            }
        });

        initData();
        initRecylerview();
    }
    private void initData() {
        userList = new ArrayList<>();
        userList.add(new customArrayAdapter(R.drawable.arrow,"Jayanagar","Banagalore","____________________________________________________________"));
        userList.add(new customArrayAdapter(R.drawable.arrow,"HSR Layout","Banagalore","____________________________________________________________"));
        userList.add(new customArrayAdapter(R.drawable.arrow,"JP Nagar","Banagalore","____________________________________________________________"));
        userList.add(new customArrayAdapter(R.drawable.arrow,"Banashankari","Banagalore","____________________________________________________________"));
        userList.add(new customArrayAdapter(R.drawable.arrow,"Lavella","Banagalore","____________________________________________________________"));
        userList.add(new customArrayAdapter(R.drawable.arrow,"Kr Nagar","Banagalore","____________________________________________________________"));
        userList.add(new customArrayAdapter(R.drawable.arrow,"Sarjapur","Banagalore","____________________________________________________________"));
        userList.add(new customArrayAdapter(R.drawable.arrow,"Whitefiled","Banagalore","____________________________________________________________"));
        userList.add(new customArrayAdapter(R.drawable.arrow,"Rajajinagar","Banagalore","____________________________________________________________"));
        userList.add(new customArrayAdapter(R.drawable.arrow,"Yashavantapur","Banagalore","____________________________________________________________"));
    }
    private void initRecylerview() {
        recyclerView=findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
