package com.example.duan1_catmusic.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan1_catmusic.R;
import com.example.duan1_catmusic.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiAdapter extends RecyclerView.Adapter<TheLoaiAdapter.ViewHoder> implements Filterable {


    private Context context;
    private List<TheLoai> list;
    private List<TheLoai> filteredList;

    public TheLoaiAdapter(Context context, ArrayList<TheLoai> list) {
        this.context = context;
        this.list = list;
        this.filteredList=list;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_theloai, parent, false);

        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheLoaiAdapter.ViewHoder holder, int position) {
        holder.name.setText(list.get(position).getTenLoai());
    }

    @Override
    public int getItemCount() {
       return list.size();
    }



    public class ViewHoder extends RecyclerView.ViewHolder {

        // khai bao cac component co o trong item

        TextView name;


        public ViewHoder(@NonNull View itemView) {
            super(itemView);

            // anh xa
            name = itemView.findViewById(R.id.name);

        }


    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String filterPattern = constraint.toString();

                if (filterPattern.isEmpty()) {
                    list = filteredList;
                } else {
                    List<TheLoai> filtered = new ArrayList<>();
                    for (TheLoai item : filteredList) {
                        if (item.getTenLoai().toLowerCase().contains(filterPattern)) {
                            filtered.add(item);
                        }
                    }
                    list = filtered;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values =list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list = (List<TheLoai>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
