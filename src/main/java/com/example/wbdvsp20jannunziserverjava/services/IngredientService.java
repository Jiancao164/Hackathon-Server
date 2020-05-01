package com.example.wbdvsp20jannunziserverjava.services;

import com.example.wbdvsp20jannunziserverjava.models.Ingredient;
import com.example.wbdvsp20jannunziserverjava.models.Recipe;
import com.example.wbdvsp20jannunziserverjava.models.Review;
import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.IngredientRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.RecipeRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.ReviewRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IngredientService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    IngredientRepository ingredientRepository;

    public List<Ingredient> findIngredients(Integer rid) {
        return ingredientRepository.findIngredients(rid);
    }

    public Ingredient createIngredient(Integer rid) {
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientDetail("new ingredient");
        Recipe recipe = recipeRepository.findRecipeById(rid);
        ingredient.setRecipe(recipe);
        return ingredientRepository.save(ingredient);
    }
    public int deleteIngredient(int iid) {
        ingredientRepository.deleteById(iid);
        return 1;
    }
    public List<Ingredient> updateIngredient(Integer rid, List<Ingredient> list) {
        List<Ingredient> ins = ingredientRepository.findIngredients(rid);
        for (Ingredient ing : ins) {
            deleteIngredient(ing.getId());
        }
        for (Ingredient ing : list) {
            Recipe recipe = recipeRepository.findRecipeById(rid);
            ing.setRecipe(recipe);
            ingredientRepository.save(ing);
        }
        return list;
    }

    public List<Recipe> findRecipes() {
        return recipeRepository.findRecipes();
    }

    public Recipe createRecipe(Integer rid) {
        Recipe recipe = new Recipe();
        recipe.setTitle("new recipe");

        return recipeRepository.save(recipe);
    }


    public List<Review> findAllReviews(String mid) {
        return reviewRepository.findAllReviews(mid);
    }

    public List<Review> findReviewsByUser(Integer uid) {
        return reviewRepository.findReviewsByUser(uid);
    }

    public Review findReviewById(int lid) {
        return reviewRepository.findReviewById(lid);
    }

    public int deleteReview(int rid) {
        reviewRepository.deleteById(rid);
        return 1;
    }

    public int updateReview(int lid, Review newReview) {
        Review oldReview = reviewRepository.findReviewById(lid);
        oldReview.setReview(newReview.getReview());
        reviewRepository.save(oldReview);
        return 1;
    }

    public Review createReview(String uid, Review newReview) {
        User user = userRepository.findUserByUsername(uid);
        newReview.setUser(user);
        return reviewRepository.save(newReview);
    }

}