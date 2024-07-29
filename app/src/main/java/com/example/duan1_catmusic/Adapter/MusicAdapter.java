package com.example.duan1_catmusic.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_catmusic.Activity.Screen_listening_music;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.Nhac;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private List<Nhac> list;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public MusicAdapter(List<Nhac> list, Context context) {
        this.list = list;
        this.context = context;
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
        holder.tvTenNhac.setText(list.get(position).getTenNhac());
        holder.tvNgheSi.setText(list.get(position).getTenCaSi());
        String imgNhac = String.valueOf(list.get(position).getHinhNhac());
        int resID = ((Activity)context).getResources().getIdentifier(imgNhac,"drawable",((Activity)context).getPackageName());
        String audioFileName = String.valueOf(list.get(position).getFileNhac());
        int residnhac = ((Activity)context).getResources().getIdentifier(audioFileName, "raw", ((Activity)context).getPackageName());


        holder.imgNhac.setImageResource(resID);
        MediaPlayer mediaPlayer = MediaPlayer.create(context, residnhac);

        // Set item click listener
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
