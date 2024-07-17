package com.example.duan1_catmusic.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.casi;

import java.util.ArrayList;

public class casiAdapter extends RecyclerView.Adapter<casiAdapter.ViewHoder>{


    private Context context;
    private ArrayList<casi> list;

    public casiAdapter(ArrayList<casi> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_casi, parent, false);

        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull casiAdapter.ViewHoder holder, int position) {
        holder.name.setText(list.get(position).getTenCaSi());
        holder.ten.setText(list.get(position).getTenCaSi());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHoder extends RecyclerView.ViewHolder {

        // khai bao cac component co o trong item

        TextView name , ten;
        LinearLayout backgroundcasi;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            // anh xa

            name = itemView.findViewById(R.id.name);
            ten = itemView.findViewById(R.id.ten);
            backgroundcasi = itemView.findViewById(R.id.backgroundcasi);
        }


    }
}
