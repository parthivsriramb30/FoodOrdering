package com.example.Rest.Controller;

import com.example.Rest.Model.Food;
import com.example.Rest.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/food", "/api/food"})
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping({"", "/add"})
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        System.out.println("Adding food item: " + food);
        return foodService.addFood(food);
    }

    
    @GetMapping({"", "/all"})
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }

   
}
