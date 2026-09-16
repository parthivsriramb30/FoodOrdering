package com.example.Rest.Service;
import com.example.Rest.Repository.FoodRepo;
import com.example.Rest.Model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepo foodRepo;

    public ResponseEntity<Food> addFood(Food food) {
        System.out.println("Inside Food Ordering Service...");
        return foodRepo.addFoodtoCollections(food);
    }

    public List<Food> getAllFoods() {
        System.out.println("Fetching all food items...");
        return foodRepo.getAllFoods();
    }

}
