package com.example.wbdvsp20jannunziserverjava.controllers;

import com.example.wbdvsp20jannunziserverjava.models.Review;
import com.example.wbdvsp20jannunziserverjava.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//https://powerful-thicket-77714.herokuapp.com
@RestController
@CrossOrigin(origins = "https://powerful-thicket-77714.herokuapp.com", allowCredentials = "true")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/users/{uid}/post")
    public Review createReview(@RequestBody Review review, @PathVariable String uid) {
        return reviewService.createReview(uid, review);
    }

    @GetMapping("/movies/{mid}/reviews")
    public List<Review> findAllReviews(@PathVariable String mid) {
        return reviewService.findAllReviews(mid);
    }

    @GetMapping("users/{uid}/reviews")
    public List<Review> findReviewsByUser(@PathVariable Integer uid) {
        return reviewService.findReviewsByUser(uid);
    }

    @DeleteMapping("reviews/{rid}")
    public int deleteReview(@PathVariable Integer rid) {
        return reviewService.deleteReview(rid);
    }





}
