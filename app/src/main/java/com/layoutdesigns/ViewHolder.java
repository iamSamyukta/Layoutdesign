package com.layoutdesigns;

import android.view.View;
import android.widget.AdapterView;

public interface ViewHolder extends View.OnClickListener {
    void setdata(int resource, String name, String name1, String name2);

    void onItemClick(AdapterView<?> parent, View view, int position, long id);
}
