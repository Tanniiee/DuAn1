package com.example.duan1_catmusic.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.example.duan1_catmusic.Activity.MoMoPaymentActivity;
import com.example.duan1_catmusic.R;

public class Premium_fm extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_premium, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find the button
        Button btnBuyPremium = view.findViewById(R.id.btnbuypremium);

        // Find TextViews
        TextView tvPrice = view.findViewById(R.id.tvprice);
        TextView tvGoi = view.findViewById(R.id.tvgoi);

        // Set onClickListener
        btnBuyPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from TextViews
                String price = tvPrice.getText().toString();
                String goi = tvGoi.getText().toString();

                // Create an Intent to start the MoMo payment activity
                Intent intent = new Intent(getActivity(), MoMoPaymentActivity.class);
                intent.putExtra("PRICE", price);
                intent.putExtra("GOI", goi);
                startActivity(intent);
            }
        });
    }

}
