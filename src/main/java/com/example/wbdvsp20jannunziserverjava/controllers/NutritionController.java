package com.example.wbdvsp20jannunziserverjava.controllers;


import com.example.wbdvsp20jannunziserverjava.models.Nutrition;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import com.example.wbdvsp20jannunziserverjava.services.NutritionService;
import com.example.wbdvsp20jannunziserverjava.services.RecipeService;
import com.example.wbdvsp20jannunziserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://pure-scrubland-90887.herokuapp.com")
public class NutritionController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;

    @Autowired
    NutritionService nutritionService;


    @GetMapping("/api/recipes/{rid}/nutrition")
    public List<Nutrition> findNutrition(@PathVariable Integer rid) {
        return nutritionService.findNutrition(rid);
    }
    @PostMapping("/api/recipes/{rid}/nutrition")
    public Nutrition createNutrition(@PathVariable Integer rid) {
        return nutritionService.createNutrition(rid);
    }
    @PutMapping("/api/recipes/{rid}/nutrition")
    public List<Nutrition> updateNutrition(@PathVariable Integer rid, @RequestBody List<Nutrition> list) {
        return nutritionService.updateNutrition(rid, list);
    }

}
