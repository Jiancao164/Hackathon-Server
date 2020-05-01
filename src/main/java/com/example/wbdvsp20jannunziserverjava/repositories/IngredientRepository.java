package com.example.wbdvsp20jannunziserverjava.repositories;

import com.example.wbdvsp20jannunziserverjava.models.Ingredient;
import com.example.wbdvsp20jannunziserverjava.models.Recipe;
import com.example.wbdvsp20jannunziserverjava.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredientRepository
        extends CrudRepository<Ingredient, Integer> {

    @Query("SELECT recipe FROM Recipe recipe")
    public List<Recipe> findRecipes();

    @Query("SELECT ingredient FROM Ingredient ingredient where ingredient.recipe.id=:rid")
    public List<Ingredient> findIngredients(@Param("rid") Integer rid);

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