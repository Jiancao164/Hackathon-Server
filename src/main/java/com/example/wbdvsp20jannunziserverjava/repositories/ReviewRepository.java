package com.example.wbdvsp20jannunziserverjava.repositories;

import com.example.wbdvsp20jannunziserverjava.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository
        extends CrudRepository<Review, Integer> {

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