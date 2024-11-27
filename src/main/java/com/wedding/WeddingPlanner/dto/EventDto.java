package com.wedding.WeddingPlanner.dto;

import com.wedding.WeddingPlanner.entity.Vendor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Getter
@Setter
public class EventDto {
    private Long id;

    private String name;

    private String eventDate;

    private String status;

    private ClientDto client;

    private Vendor vendor;
    public void validateEventDate() {
        // Define the expected date format (e.g., "yyyy-MM-dd")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Parse the eventDate String to LocalDate
            LocalDate eventDateParsed = LocalDate.parse(this.eventDate, formatter);

            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Compare event date with current date
            if (eventDateParsed.isBefore(currentDate)) {
                throw new IllegalArgumentException("Event date cannot be in the past.");
            }

            // If the event date is valid, continue with scheduling
            System.out.println("Event scheduled for: " + eventDateParsed);

        } catch (DateTimeParseException e) {
            // If the date is invalid (incorrect format), throw an exception
            throw new IllegalArgumentException("Invalid date format. Please use 'yyyy-MM-dd'.", e);
        }
    }
}
