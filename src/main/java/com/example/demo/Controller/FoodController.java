package com.example.demo.controller;

import com.example.Rest.Model.Food;
import com.example.Rest.Service.FoodService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/add")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        return foodService.addFood(food);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFoods() {
        return ResponseEntity.ok(foodService.getAllFoods());
    }
}