package com.example.wbdvsp20jannunziserverjava.repositories;

import com.example.wbdvsp20jannunziserverjava.models.Calendar;
import com.example.wbdvsp20jannunziserverjava.models.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalendarRepository
        extends CrudRepository<Calendar, Integer> {

    @Query("SELECT calendar FROM Calendar calendar")
    public List<Calendar> findCalendars();

    @Query("SELECT calendar FROM Calendar calendar WHERE calendar.id=:rid")
    public Calendar findCalendarById(
            @Param("rid") int rid);




}