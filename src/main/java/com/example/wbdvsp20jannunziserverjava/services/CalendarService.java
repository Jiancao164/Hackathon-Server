package com.example.wbdvsp20jannunziserverjava.services;

import com.example.wbdvsp20jannunziserverjava.models.Calendar;
import com.example.wbdvsp20jannunziserverjava.models.Review;
import com.example.wbdvsp20jannunziserverjava.models.User;
import com.example.wbdvsp20jannunziserverjava.repositories.CalendarRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.ReviewRepository;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CalendarService {



    @Autowired
    CalendarRepository calendarRepository;

    public List<Calendar> findCalendars() {
        return calendarRepository.findCalendars();
    }





    public Calendar updateCalendar(Calendar calendar) {
        Calendar calendar2 = new Calendar();
        calendar2.setId(1);
        calendar2.setUrl(calendar.getUrl());

        return calendarRepository.save(calendar2);
    }


}