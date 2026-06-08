package com.example.cravy.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cravy.R;
import com.example.cravy.adapter.FoodAdapter;
import com.example.cravy.model.Food;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rvFood;
    private FoodAdapter foodAdapter;
    private List<Food> foodList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvFood = view.findViewById(R.id.rv_food);

        rvFood.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        foodList = new ArrayList<>();
        foodList.add(new Food("1", "Classic Burger", "Juicy beef patty with fresh lettuce, cheese, and special sauce.", "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?q=80&w=500", "$8.99"));
        foodList.add(new Food("2", "Classic Pizza", "Delicious homemade pizza with pepperoni and melted mozzarella.", "https://images.unsplash.com/photo-1513104890138-7c749659a591?q=80&w=500", "$9.91"));
        foodList.add(new Food("3", "Signature Noodles", "Spicy stir-fried noodles with authentic Asian flavors.", "https://images.unsplash.com/photo-1585032226651-759b368d7246?q=80&w=500", "$7.99"));
        foodList.add(new Food("4", "Avocado Sandwich", "Healthy toast with fresh avocado slices and crispy bacon.", "https://images.unsplash.com/photo-1528735602780-2552fd46c7af?q=80&w=500", "$7.49"));

        foodAdapter = new FoodAdapter(foodList, food -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("food_data", food);

            androidx.navigation.Navigation.findNavController(requireView())
                    .navigate(R.id.action_homeFragment_to_detailFragment, bundle);
        });
        rvFood.setAdapter(foodAdapter);
    }
}