package com.example.duan1_catmusic.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.Nhac;

import java.io.IOException;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private List<Nhac> list;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public MusicAdapter(List<Nhac> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void updateData(List<Nhac> newList) {
        this.list = newList;
        notifyDataSetChanged();  // Cập nhật giao diện người dùng với dữ liệu mới
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_bai_nhac, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Nhac nhac = list.get(position);
        holder.tvTenNhac.setText(nhac.getTenNhac());
        holder.tvNgheSi.setText(nhac.getTenCaSi());

        // Hiển thị hình ảnh
        String imgNhac = nhac.getHinhNhac();
        int resID = ((Activity) context).getResources().getIdentifier(imgNhac, "drawable", ((Activity) context).getPackageName());
        holder.imgNhac.setImageResource(resID);

        // Set click listener for the item
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                int pos = holder.getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    onItemClickListener.onItemClick(pos);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgNhac;
        TextView tvTenNhac;
        TextView tvNgheSi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgNhac = itemView.findViewById(R.id.img_item_listnhac);
            tvTenNhac = itemView.findViewById(R.id.tvTenNhac);
            tvNgheSi = itemView.findViewById(R.id.tvNgheSi);
        }
    }
}
