package com.example.wbdvsp20jannunziserverjava.services;

import com.example.wbdvsp20jannunziserverjava.models.Review;
import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.ReviewRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;

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