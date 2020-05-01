package com.example.wbdvsp20jannunziserverjava.services;


import com.example.wbdvsp20jannunziserverjava.models.Recipe;
import com.example.wbdvsp20jannunziserverjava.models.Review;
import com.example.wbdvsp20jannunziserverjava.models.Step;
import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.ProcessRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.RecipeRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.ReviewRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProcessService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    ProcessRepository processRepository;

    public List<Step> findProcess(Integer rid) {
        return processRepository.findProcess(rid);
    }

    public Step createProcess(Integer rid) {
        Step process = new Step();
        process.setProcessDetail("");
        Recipe recipe = recipeRepository.findRecipeById(rid);
        process.setRecipe(recipe);
        return processRepository.save(process);
    }
    public int deleteProcess(int iid) {
        processRepository.deleteById(iid);
        return 1;
    }
    public List<Step> updateProcess(Integer rid, List<Step> list) {
        List<Step> ins = processRepository.findProcess(rid);
        for (Step ing : ins) {
            deleteProcess(ing.getId());
        }
        for (Step ing : list) {
            Recipe recipe = recipeRepository.findRecipeById(rid);
            ing.setRecipe(recipe);
            processRepository.save(ing);
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