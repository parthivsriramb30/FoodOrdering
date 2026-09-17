package com.example.Rest.Repository;

import com.example.Rest.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByIsAvailable(Boolean isAvailable);
    List<Food> findByFoodNameContainingIgnoreCase(String foodName);
}