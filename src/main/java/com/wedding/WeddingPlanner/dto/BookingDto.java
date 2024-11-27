package com.wedding.WeddingPlanner.dto;

import com.wedding.WeddingPlanner.entity.Booking;
import com.wedding.WeddingPlanner.entity.Event;
import com.wedding.WeddingPlanner.entity.Vendor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingDto {
    private Long id;

    private String bookingDate;

    private boolean confirmed;

    private Event event;

    private Vendor vendor;

}
