package com.example.wbdvsp20jannunziserverjava.controllers;

import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import com.example.wbdvsp20jannunziserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "https://powerful-thicket-77714.herokuapp.com", allowCredentials = "true")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;



    @PostMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @PostMapping("/login")
    public User login(HttpSession session,
                      @RequestBody User user) {
        User profile = userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
        session.setAttribute("profile", profile);
        return profile;
    }

    @PostMapping("/register")
    public User register(HttpSession session,
                         @RequestBody User user) {
        User newUser = userRepository.save(user);
        newUser.setPassword("***");
        session.setAttribute("profile", newUser);
        return newUser;
    }



//    @PostMapping("/{mid}/post")
//    public User post(@RequestBody User user,
//                     @PathVariable int mid) {
//        User profile = repository.findUserByCredentials(user.getUsername(), user.getPassword());
//        profile.setReviews(profile.getReviews().containsKey(mid)? profile.getReviews().get(mid).add());
//        session.setAttribute("profile", newUser);
//        return newUser;
//    }

    @GetMapping("/profile")
    public User profile(HttpSession session) {
        if (session.getAttribute("profile") == null) return null;
        User profile = (User)session.getAttribute("profile");
        profile = userRepository.findUserByUsername(profile.getUsername());
        return profile;
    }
    @GetMapping("/profile/{username}")
    public User findUserByUsername(@PathVariable String username) {
        User user = userRepository.findUserByUsername(username);
        user.setPassword("***");
        return user;
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        User profile = userRepository.findUserByUsername(user.getUsername());
        //profile.setPassword("745afs");
        profile.setEmail(user.getEmail());
        profile.setPhone(user.getPhone());
        profile.setRole(user.getRole());
        return userRepository.save(user);
    }

    @GetMapping("movies{mid}/reviews/{rid}/user")
    public User findUserByReview(@PathVariable String mid, @PathVariable String rid) {
        return userService.findUserByReview(rid, mid);
    }
}
