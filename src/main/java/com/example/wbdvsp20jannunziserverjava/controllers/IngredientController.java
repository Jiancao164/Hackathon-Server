package com.example.wbdvsp20jannunziserverjava.controllers;

import com.example.wbdvsp20jannunziserverjava.models.Ingredient;
import com.example.wbdvsp20jannunziserverjava.models.Recipe;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import com.example.wbdvsp20jannunziserverjava.services.IngredientService;
import com.example.wbdvsp20jannunziserverjava.services.RecipeService;
import com.example.wbdvsp20jannunziserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://pure-scrubland-90887.herokuapp.com")
public class IngredientController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;

    @Autowired
    IngredientService ingredientService;
//
//    @PostMapping("/logout")
//    public void logout(HttpSession session) {
//        session.invalidate();
//    }
//
//    @PostMapping("/login")
//    public User login(HttpSession session,
//                      @RequestBody User user) {
//        User profile = userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
//        session.setAttribute("profile", profile);
//        return profile;
//    }
//
//    @PostMapping("/register")
//    public User register(HttpSession session,
//                         @RequestBody User user) {
//        User newUser = userRepository.save(user);
//        newUser.setPassword("***");
//        session.setAttribute("profile", newUser);
//        return newUser;
//    }

    @GetMapping("/api/recipes/{rid}")
    public List<Ingredient> findIngredient(@PathVariable Integer rid) {
        return ingredientService.findIngredients(rid);
    }
    @PostMapping("/api/recipes/{rid}")
    public Ingredient createIngredient(@PathVariable Integer rid) {
        return ingredientService.createIngredient(rid);
    }
    @PutMapping("/api/recipes/{rid}")
    public List<Ingredient> updateIngredient(@PathVariable Integer rid, @RequestBody List<Ingredient> list) {
        return ingredientService.updateIngredient(rid, list);
    }

}
