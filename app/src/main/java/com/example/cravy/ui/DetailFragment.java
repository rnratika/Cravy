package com.example.cravy.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.cravy.R;
import com.example.cravy.model.Food;

public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView ivImage = view.findViewById(R.id.iv_detail_image);
        TextView tvName = view.findViewById(R.id.tv_detail_name);
        TextView tvPrice = view.findViewById(R.id.tv_detail_price);
        TextView tvDesc = view.findViewById(R.id.tv_detail_description);

        if (getArguments() != null) {
            Food food = (Food) getArguments().getSerializable("food_data");

            if (food != null) {
                tvName.setText(food.getName());
                tvPrice.setText(food.getPrice());
                tvDesc.setText(food.getDescription());

                Glide.with(this)
                        .load(food.getImageUrl())
                        .into(ivImage);
            }
        }
    }
}