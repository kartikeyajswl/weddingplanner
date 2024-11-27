package com.wedding.WeddingPlanner.service;


import com.wedding.WeddingPlanner.dto.BookingDto;
import com.wedding.WeddingPlanner.entity.Booking;
import com.wedding.WeddingPlanner.entity.Client;
import com.wedding.WeddingPlanner.entity.Event;
import com.wedding.WeddingPlanner.entity.Vendor;
import com.wedding.WeddingPlanner.repository.BookingRepository;
import com.wedding.WeddingPlanner.repository.ClientRepository;
import com.wedding.WeddingPlanner.repository.EventRepository;
import com.wedding.WeddingPlanner.repository.VendorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private ModelMapper modelMapper;
    private VendorRepository vendorRepository;
    private BookingRepository bookRepository;
    private EventRepository eventRepository;
    private ClientRepository clientRepository;

    public BookingService(ModelMapper modelMapper,
                          VendorRepository vendorRepository,
                          BookingRepository bookRepository,
                          EventRepository eventRepository,
                          ClientRepository clientRepository) {
        this.modelMapper = modelMapper;
        this.vendorRepository = vendorRepository;
        this.bookRepository = bookRepository;
        this.eventRepository = eventRepository;
        this.clientRepository = clientRepository;
    }

    public BookingDto createBooking(long vendorId, long eventId, long clientId, BookingDto bookingDto) {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("client not found" + clientId));
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("vendor not found" + vendorId));
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("event not found" + eventId));
        event.validateEventDate();
        if (client.getBudget() < vendor.getServicePrice()) {
            throw new RuntimeException("Client’s budget cannot cover the vendor’s services.");
        }
        booking.setClient(client);
        booking.setEvent(event);
        booking.setVendor(vendor);
        Booking savedBooking = bookRepository.save(booking);
        return modelMapper.map(savedBooking, BookingDto.class);
    }


    public BookingDto cancelBooking(long bookingId) {
        Booking booking = bookRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("booking not found" + bookingId));
        booking.setConfirmed(false);
        Booking save = bookRepository.save(booking);
        return modelMapper.map(save, BookingDto.class);
    }
}
