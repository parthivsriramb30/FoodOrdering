package com.example.Rest.Service;

import com.example.Rest.Exception.ResourceNotFoundException;
import com.example.Rest.Model.Food;
import com.example.Rest.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    public Food getFoodById(Long id) {
        return foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with ID: " + id));
    }

    public Food updateFood(Long id, Food foodDetails) {
        Food existingFood = foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with ID: " + id));

        if (foodDetails.getFoodName() != null) {
            existingFood.setFoodName(foodDetails.getFoodName());
        }
        if (foodDetails.getPrice() != null) {
            existingFood.setPrice(foodDetails.getPrice());
        }
        if (foodDetails.isAvailable() != null) {
            existingFood.setAvailable(foodDetails.isAvailable());
        }

        return foodRepository.save(existingFood);
    }

    public void deleteFood(Long id) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with ID: " + id));
        foodRepository.delete(food);
    }

    public List<Food> getFoodByAvailability(Boolean isAvailable) {
        return foodRepository.findByIsAvailable(isAvailable);
    }

    public List<Food> searchFoodByName(String foodName) {
        return foodRepository.findByFoodNameContainingIgnoreCase(foodName);
    }
}