package com.wedding.WeddingPlanner.repository;

import com.wedding.WeddingPlanner.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.status IN ('upcoming', 'completed')")
    List<Event> findEventByUpcomingOrCompletedStatus(String eventStatus);}