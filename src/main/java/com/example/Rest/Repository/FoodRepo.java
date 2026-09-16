package com.example.Rest.Repository;
import com.example.Rest.Model.Food;
import org.springframework.http.ResponseEntity;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepo {
    private final List<Food> orderedFoods = new ArrayList<>();

    public ResponseEntity<Food> addFoodtoCollections(Food food) {
        System.out.println("Inside Food Ordering Repository...");
        orderedFoods.add(food);
        return ResponseEntity.ok(food);
    }

    public List<Food> getAllFoods() {
        System.out.println("Returning all food items from repository...");
        return orderedFoods;
    }

}
