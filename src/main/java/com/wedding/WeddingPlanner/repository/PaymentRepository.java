package com.wedding.WeddingPlanner.repository;

import com.wedding.WeddingPlanner.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findAllPaymentByStatus(String paymentStatus);
}