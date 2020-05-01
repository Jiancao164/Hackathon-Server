package com.example.wbdvsp20jannunziserverjava.repositories;

import com.example.wbdvsp20jannunziserverjava.models.Recipe;
import com.example.wbdvsp20jannunziserverjava.models.Review;
import com.example.wbdvsp20jannunziserverjava.models.Nutrition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NutritionRepository
        extends CrudRepository<Nutrition, Integer> {

    @Query("SELECT recipe FROM Recipe recipe")
    public List<Recipe> findRecipes();

    @Query("SELECT nutrition FROM Nutrition nutrition where nutrition.recipe.id=:rid")
    public List<Nutrition> findNutrition(@Param("rid") Integer rid);

    @Query("SELECT review FROM Review review WHERE review.id=:reviewId")
    public Review findReviewById(
            @Param("reviewId") int lid);

    @Query("select review from Review review where review.movieId=:mid")
    public List<Review> findAllReviews(
            @Param("mid") String movieId);

    @Query("select review from Review review where review.user.id=:uid")
    public List<Review> findReviewsByUser(
            @Param("uid") Integer username);
//    @Query("select review from Review review where review.user.id=:mid")
//    public List<Review> findAllReviews(
//            @Param("mid") String moduleId);


}