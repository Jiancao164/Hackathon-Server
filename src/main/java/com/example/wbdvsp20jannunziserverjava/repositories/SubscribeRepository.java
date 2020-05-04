package com.example.wbdvsp20jannunziserverjava.repositories;

import com.example.wbdvsp20jannunziserverjava.models.Subscribe;
import com.example.wbdvsp20jannunziserverjava.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubscribeRepository
        extends CrudRepository<Subscribe, Integer> {

    @Query("SELECT subscribe FROM Subscribe subscribe")
    public List<Subscribe> findSubscribes();




//    @Query("select review from Review review where review.user.id=:mid")
//    public List<Review> findAllReviews(
//            @Param("mid") String moduleId);


}