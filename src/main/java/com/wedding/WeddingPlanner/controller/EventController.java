package com.wedding.WeddingPlanner.controller;


import com.wedding.WeddingPlanner.dto.EventDto;
import com.wedding.WeddingPlanner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {


    @Autowired
    private EventService eventService;

   @PostMapping("/event")
    public ResponseEntity<EventDto> addEvent(@RequestBody EventDto eventDto
           ,@RequestParam long clientId
           , @RequestParam long vendorId){
        EventDto eventDto1 = eventService.addEvent(eventDto,clientId, vendorId);
        return ResponseEntity.ok(eventDto1);
    }


    @GetMapping("/events/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable long eventId){
        EventDto eventDto1 = eventService.getEventById(eventId);
        return ResponseEntity.ok(eventDto1);
    }
   @GetMapping("/events")
   public ResponseEntity<List<EventDto>> findEventByStatus(@RequestParam String eventStatus ){
       List<EventDto> eventByStatus = eventService.findEventByStatus(eventStatus);
       return ResponseEntity.ok(eventByStatus);
   }

}
