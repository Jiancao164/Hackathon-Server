package com.example.wbdvsp20jannunziserverjava.services;

import com.example.wbdvsp20jannunziserverjava.models.Subscribe;
import com.example.wbdvsp20jannunziserverjava.models.Subscribe;
import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.SubscribeRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.SubscribeRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SubscribeService {



    @Autowired
    SubscribeRepository subscribeRepository;

    public List<Subscribe> findSubscribes() {
        return subscribeRepository.findSubscribes();
    }

    public Subscribe createSubscribe(Subscribe subscribe) {
        return subscribeRepository.save(subscribe);
    }
















}