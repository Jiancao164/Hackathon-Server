package com.example.wbdvsp20jannunziserverjava.services;


import com.example.wbdvsp20jannunziserverjava.models.Recipe;
import com.example.wbdvsp20jannunziserverjava.models.Review;
import com.example.wbdvsp20jannunziserverjava.models.Nutrition;
import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.NutritionRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.RecipeRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.ReviewRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NutritionService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    NutritionRepository nutritionRepository;

    public List<Nutrition> findNutrition(Integer rid) {
        return nutritionRepository.findNutrition(rid);
    }

    public Nutrition createNutrition(Integer rid) {
        Nutrition nutrition = new Nutrition();
        nutrition.setNutritionDetail("");
        Recipe recipe = recipeRepository.findRecipeById(rid);
        nutrition.setRecipe(recipe);
        return nutritionRepository.save(nutrition);
    }
    public int deleteNutrition(int iid) {
        nutritionRepository.deleteById(iid);
        return 1;
    }
    public List<Nutrition> updateNutrition(Integer rid, List<Nutrition> list) {
        List<Nutrition> ins = nutritionRepository.findNutrition(rid);
        for (Nutrition ing : ins) {
            deleteNutrition(ing.getId());
        }
        for (Nutrition ing : list) {
            Recipe recipe = recipeRepository.findRecipeById(rid);
            ing.setRecipe(recipe);
            nutritionRepository.save(ing);
        }
        return list;
    }




}