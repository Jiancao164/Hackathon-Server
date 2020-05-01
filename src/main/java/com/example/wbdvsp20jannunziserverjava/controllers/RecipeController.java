package com.example.wbdvsp20jannunziserverjava.controllers;

import com.example.wbdvsp20jannunziserverjava.models.Recipe;
import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import com.example.wbdvsp20jannunziserverjava.services.RecipeService;
import com.example.wbdvsp20jannunziserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://pure-scrubland-90887.herokuapp.com")
public class RecipeController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;



    @PostMapping("/api/recipes")
    public Recipe createRecipe(@RequestBody String recipe) {
        return recipeService.createRecipe();
    }

    @DeleteMapping("/api/recipes/{rid}")
    public int deleteRecipe(@PathVariable Integer rid) {
        return recipeService.deleteRecipe(rid);
    }

    @GetMapping("/api/recipes")
    public List<Recipe> findRecipes() {
        return recipeService.findRecipes();
    }
    @GetMapping("/api/recipes/{rid}/url")
    public Recipe findRecipeById(@PathVariable Integer rid) {
        return recipeService.findRecipeById(rid);
    }
    @PutMapping("/api/recipes/{rid}/url")
    public Recipe updateRecipe(@PathVariable Integer rid, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(rid, recipe);
    }

}
