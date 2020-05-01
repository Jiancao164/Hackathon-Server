package com.example.wbdvsp20jannunziserverjava.repositories;

import com.example.wbdvsp20jannunziserverjava.models.Recipe;
import com.example.wbdvsp20jannunziserverjava.models.Review;
import com.example.wbdvsp20jannunziserverjava.models.Step;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProcessRepository
        extends CrudRepository<Step, Integer> {

    @Query("SELECT recipe FROM Recipe recipe")
    public List<Recipe> findRecipes();

    @Query("SELECT process FROM Step process where process.recipe.id=:rid")
    public List<Step> findProcess(@Param("rid") Integer rid);

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