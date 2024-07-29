package com.example.duan1_catmusic.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_catmusic.Activity.DanhSachBaiHat;
import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.Casi;

import java.util.ArrayList;

public class thuvienAdapter extends RecyclerView.Adapter<thuvienAdapter.ViewHoder>{
    private Context context;
    private ArrayList<Casi> list;

    public thuvienAdapter(Context context, ArrayList<Casi> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_listcasi_thuvien, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        holder.tvTencasi.setText(list.get(position).getTenCaSi());
        String ivHinhcasi = String.valueOf(list.get(position).getHinhalbum());
        int resID = ((Activity)context).getResources().getIdentifier(ivHinhcasi, "drawable", ((Activity)context).getPackageName());
        holder.iv_hinhCasi.setImageResource(resID);

        // Xử lý nhấn giữ để hiện popup menu
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_admin_nghesi, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.action_editns) {
                            // Xử lý sửa item
                            // Thực hiện hành động khi chọn "sửa"
                            return true;
                        } else if (item.getItemId() == R.id.action_deletens) {
                            // Xử lý xóa item
                            // Thực hiện hành động khi chọn "xóa"
                            return true;
                        } else {
                            return false;
                        }
                    }
                });

                popupMenu.show();
                return true;
            }
        });

        // Xử lý nhấn đơn để mở activity DanhSachBaiHat
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhSachBaiHat.class);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        TextView tvTencasi;
        ImageView iv_hinhCasi;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            tvTencasi = itemView.findViewById(R.id.tvTenCasi);
            iv_hinhCasi = itemView.findViewById(R.id.iv_nghesi_thuvien);
        }
    }
}
