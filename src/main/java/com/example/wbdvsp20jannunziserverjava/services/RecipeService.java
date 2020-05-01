package com.example.wbdvsp20jannunziserverjava.services;

import com.example.wbdvsp20jannunziserverjava.models.Recipe;
import com.example.wbdvsp20jannunziserverjava.models.Review;
import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.RecipeRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.ReviewRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecipeService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecipeRepository recipeRepository;

    public List<Recipe> findRecipes() {
        return recipeRepository.findRecipes();
    }

    public Recipe createRecipe() {
        Recipe recipe = new Recipe();
        recipe.setTitle("new recipe");
        recipe.setUrl("");
        recipe.setCookTime("");
        recipe.setPreTime("");
        recipe.setServings("");
        return recipeRepository.save(recipe);
    }

    public Recipe findRecipeById(int rid) {
        return recipeRepository.findRecipeById(rid);
    }

    public Recipe updateRecipe(int rid, Recipe recipe) {
        Recipe recipe1 = recipeRepository.findRecipeById(rid);
        recipe1.setTitle(recipe.getTitle());
        recipe1.setUrl(recipe.getUrl());
        recipe1.setPreTime(recipe.getPreTime());
        recipe1.setCookTime(recipe.getCookTime());
        recipe1.setServings(recipe.getServings());
        return recipeRepository.save(recipe1);
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

    public int deleteRecipe(int rid) {
        recipeRepository.deleteById(rid);
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