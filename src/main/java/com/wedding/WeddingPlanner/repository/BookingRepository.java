package com.wedding.WeddingPlanner.repository;

import com.wedding.WeddingPlanner.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}