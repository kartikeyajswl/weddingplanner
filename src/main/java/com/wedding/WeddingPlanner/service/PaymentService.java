package com.wedding.WeddingPlanner.service;


import com.wedding.WeddingPlanner.dto.PaymentDto;
import com.wedding.WeddingPlanner.entity.Payment;
import com.wedding.WeddingPlanner.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;
    private ModelMapper modelMapper;

    public PaymentService(PaymentRepository paymentRepository, ModelMapper modelMapper) {
        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
    }

    public PaymentDto recordPayment(PaymentDto paymentDto) {
        Payment payment = modelMapper.map(paymentDto, Payment.class);
        Payment save = paymentRepository.save(payment);
        return modelMapper.map(save, PaymentDto.class);
    }

    public List<PaymentDto> getAllPaymentsByStatus(String paymentStatus) {
            if(paymentStatus.equalsIgnoreCase("pending")||paymentStatus.equalsIgnoreCase("paid")){
            List<Payment> allPaymentByStatus = paymentRepository.findAllPaymentByStatus(paymentStatus);
            return allPaymentByStatus.stream().map(s->modelMapper.map(s, PaymentDto.class)).collect(Collectors.toList());
        }
            throw new IllegalArgumentException("Invalid payment status: " + paymentStatus);
    }
}
