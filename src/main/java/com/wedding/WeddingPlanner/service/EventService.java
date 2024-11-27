package com.wedding.WeddingPlanner.service;


import com.wedding.WeddingPlanner.dto.EventDto;
import com.wedding.WeddingPlanner.entity.Client;
import com.wedding.WeddingPlanner.entity.Event;
import com.wedding.WeddingPlanner.entity.Vendor;
import com.wedding.WeddingPlanner.repository.ClientRepository;
import com.wedding.WeddingPlanner.repository.EventRepository;
import com.wedding.WeddingPlanner.repository.VendorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private EventRepository eventRepository;
    private ModelMapper modelMapper;
    private VendorRepository vendorRepository;
    private ClientRepository clientRepository;

    public EventService(EventRepository eventRepository,
                        ModelMapper modelMapper,
                        VendorRepository vendorRepository,
                        ClientRepository clientRepository) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
        this.vendorRepository = vendorRepository;
        this.clientRepository = clientRepository;
    }

    public EventDto addEvent(EventDto eventDto, long clientId, long vendorId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("client not found" + clientId));
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("vendor not found" + vendorId));
        Event event = modelMapper.map(eventDto,Event.class);
        event.validateEventDate();
        event.setClient(client);
        event.setVendor(vendor);
        Event savedEvent = eventRepository.save(event);
        return modelMapper.map(savedEvent, EventDto.class);
    }

    public EventDto getEventById(long eventId) {
             Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("event not found" + eventId));
        return modelMapper.map(event,EventDto.class);

    }


    public List<EventDto> findEventByStatus(String eventStatus) {
        if(eventStatus.equalsIgnoreCase("upcoming")||eventStatus.equalsIgnoreCase("completed")) {
            List<Event> eventList = eventRepository.findEventByUpcomingOrCompletedStatus(eventStatus);
            return eventList.stream().map(s -> modelMapper.map(s, EventDto.class)).collect(Collectors.toList());
        }
             throw new IllegalArgumentException("Event not found"+eventStatus);
    }
}
