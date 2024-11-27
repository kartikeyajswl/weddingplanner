package com.wedding.WeddingPlanner.controller;


import com.wedding.WeddingPlanner.dto.PaymentDto;
import com.wedding.WeddingPlanner.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(" /payments")
    public ResponseEntity<PaymentDto> recordPayment(@RequestBody PaymentDto paymentDto){
        PaymentDto paymentDto1 = paymentService.recordPayment(paymentDto);
        return ResponseEntity.ok(paymentDto1);
    }

    @GetMapping("/paymentStatus")
    public ResponseEntity<List<PaymentDto>> getAllPaymentsByStatus(@RequestParam String paymentStatus) {
        List<PaymentDto> paymentDtos = paymentService.getAllPaymentsByStatus(paymentStatus);
        return ResponseEntity.ok(paymentDtos);
    }
}
