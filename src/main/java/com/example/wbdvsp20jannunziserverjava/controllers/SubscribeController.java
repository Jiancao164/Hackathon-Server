package com.example.wbdvsp20jannunziserverjava.controllers;

import com.example.wbdvsp20jannunziserverjava.models.Subscribe;
import com.example.wbdvsp20jannunziserverjava.services.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//https://powerful-thicket-77714.herokuapp.com
@RestController
@CrossOrigin(origins = "*", allowCredentials = "true")
public class SubscribeController {


    @Autowired
    SubscribeService subscribeService;

    @PostMapping("/api/subscribes")
    public Subscribe createSubscribe(@RequestBody Subscribe subscribe) {
        return subscribeService.createSubscribe(subscribe);
    }

    @GetMapping("/api/subscribes")
    public List<Subscribe> findSubscribes() {
        return subscribeService.findSubscribes();
    }


}
