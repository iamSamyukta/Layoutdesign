package com.layoutdesigns;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class customArrayAdapter {
    private  String Area;
    private String City;
    private int imageview;
    private String divider;


    customArrayAdapter(int imageview,String Area,String City,String divider){
        this.imageview=imageview;
        this.Area=Area;
        this.City=City;
        this.divider=divider;

    }

    public String getArea() {
        return Area;
    }

    public String getCity() {
        return City;
    }

    public int getImageview() {
        return imageview;
    }

    public String getdivider() {
        return divider;
    }
}
