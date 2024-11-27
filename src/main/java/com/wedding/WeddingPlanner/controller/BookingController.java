package com.wedding.WeddingPlanner.controller;


import com.wedding.WeddingPlanner.dto.BookingDto;
import com.wedding.WeddingPlanner.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @PostMapping(" /bookings")
    public ResponseEntity<BookingDto>createBooKing(@RequestParam long vendorId,
                                                   @RequestParam long eventId,
                                                   @RequestParam long clientId,
                                                   @RequestBody BookingDto bookingDto){
        BookingDto booking = bookingService.createBooking(vendorId, eventId, clientId,bookingDto);
        return ResponseEntity.ok(booking);
    }


    @GetMapping("/bookings/{bookingId}/cancel")
    public ResponseEntity<BookingDto> cancelBooking(@PathVariable long bookingId){
        BookingDto booking = bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok(booking);
    }
}
