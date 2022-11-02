package com.layoutdesigns;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<customArrayAdapter> userList;

    public Adapter(List<customArrayAdapter> userList) {
        this.userList = userList;

    }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int resource = userList.get(position).getImageview();
        String name = userList.get(position).getArea();
        String name1 = userList.get(position).getCity();
        String name2 = userList.get(position).getdivider();


        holder.setdata(resource, name, name1, name2);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView Area;
        private TextView City;
        private TextView divider;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            Area = itemView.findViewById(R.id.Area);
            City = itemView.findViewById(R.id.City);
            divider = itemView.findViewById(R.id.divider);
            itemView.setOnClickListener(this);

        }

        public void setdata(int resource, String name, String name1, String name2) {

            imageView.setImageResource(resource);
            Area.setText(name);
            City.setText(name1);
            divider.setText(name2);
        }


        @Override
        public void onClick(View v) {
            int postion = getAdapterPosition();
//             Toast.makeText(v.getContext(), "postion"+1, Toast.LENGTH_SHORT).show();
            if (postion == 0) {
                Intent intent = new Intent(v.getContext(), Jayanagar.class);
                v.getContext().startActivity(intent);
            }
            if (postion == 1) {
                Intent intent = new Intent(v.getContext(), hsrlayout.class);
                v.getContext().startActivity(intent);
            }

        }
    }
}


