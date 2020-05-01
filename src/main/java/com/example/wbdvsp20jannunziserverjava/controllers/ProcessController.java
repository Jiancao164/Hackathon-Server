package com.example.wbdvsp20jannunziserverjava.controllers;


import com.example.wbdvsp20jannunziserverjava.models.Step;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import com.example.wbdvsp20jannunziserverjava.services.ProcessService;
import com.example.wbdvsp20jannunziserverjava.services.RecipeService;
import com.example.wbdvsp20jannunziserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProcessController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    RecipeService recipeService;

    @Autowired
    ProcessService processService;
//
//    @PostMapping("/logout")
//    public void logout(HttpSession session) {
//        session.invalidate();
//    }
//
//    @PostMapping("/login")
//    public User login(HttpSession session,
//                      @RequestBody User user) {
//        User profile = userRepository.findUserByCredentials(user.getUsername(), user.getPassword());
//        session.setAttribute("profile", profile);
//        return profile;
//    }
//
//    @PostMapping("/register")
//    public User register(HttpSession session,
//                         @RequestBody User user) {
//        User newUser = userRepository.save(user);
//        newUser.setPassword("***");
//        session.setAttribute("profile", newUser);
//        return newUser;
//    }

    @GetMapping("/api/recipes/{rid}/steps")
    public List<Step> findProcess(@PathVariable Integer rid) {
        return processService.findProcess(rid);
    }
    @PostMapping("/api/recipes/{rid}/steps")
    public Step createProcess(@PathVariable Integer rid) {
        return processService.createProcess(rid);
    }
    @PutMapping("/api/recipes/{rid}/steps")
    public List<Step> updateProcess(@PathVariable Integer rid, @RequestBody List<Step> list) {
        return processService.updateProcess(rid, list);
    }
//    @GetMapping("/profile/{username}")
//    public User findUserByUsername(@PathVariable String username) {
//        User user = userRepository.findUserByUsername(username);
//        user.setPassword("***");
//        return user;
//    }
//
//    @PutMapping("/update")
//    public User update(@RequestBody User user) {
//        User profile = userRepository.findUserByUsername(user.getUsername());
//        //profile.setPassword("745afs");
//        profile.setEmail(user.getEmail());
//        profile.setPhone(user.getPhone());
//        profile.setRole(user.getRole());
//        return userRepository.save(user);
//    }
//
//    @GetMapping("movies{mid}/reviews/{rid}/user")
//    public User findUserByReview(@PathVariable String mid, @PathVariable String rid) {
//        return userService.findUserByReview(rid, mid);
//    }
}
