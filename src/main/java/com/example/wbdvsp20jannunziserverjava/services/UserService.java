package com.example.wbdvsp20jannunziserverjava.services;

import com.example.wbdvsp20jannunziserverjava.models.Review;
import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReviewService reviewService;



//    public List<User> findAllUsers(String mid) {
//        return userRepository.findAllUsers(mid);
//    }

    public User findUserByReview(String rid, String mid) {
        List<Review> reviews = reviewService.findAllReviews(mid);
        User user = null;
        for (Review review : reviews) {
            if (review.getId().toString().equals(rid)) {
                user = review.getUser();
                break;
            }
        }

        return user;
    }

//    public int deleteUser(int lid) {
//        userRepository.deleteById(lid);
//        return 1;
//    }

//    public int updateUser(int lid, User newUser) {
//        User oldUser = userRepository.findUserById(lid);
//        oldUser.setUser(newUser.getUser());
//        userRepository.save(oldUser);
//        return 1;
//    }
//
//    public User createUser(String uid, User newUser) {
//        User user = userRepository.findUserById(uid);
//        newUser.setUser(user);
//        return userRepository.save(newUser);
//    }

}