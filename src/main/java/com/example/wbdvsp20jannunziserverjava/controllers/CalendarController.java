package com.example.wbdvsp20jannunziserverjava.controllers;

import com.example.wbdvsp20jannunziserverjava.models.Calendar;
import com.example.wbdvsp20jannunziserverjava.repositories.UserRepository;
import com.example.wbdvsp20jannunziserverjava.services.CalendarService;
import com.example.wbdvsp20jannunziserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CalendarController {


    @Autowired
    CalendarService calendarService;


    @GetMapping("/api/calendars")
    public List<Calendar> findCalendars() {
        return calendarService.findCalendars();
    }

    @PutMapping("/api/calendars")
    public Calendar updateCalendar(@RequestBody Calendar calendar) {
        return calendarService.updateCalendar(calendar);
    }

}
