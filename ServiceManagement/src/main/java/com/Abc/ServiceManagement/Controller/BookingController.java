package com.Abc.ServiceManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Abc.ServiceManagement.Dto.BookingConfirmationDTO;
import com.Abc.ServiceManagement.Dto.BookingRequestDTO;
import com.Abc.ServiceManagement.Exception.ApiResponse;
import com.Abc.ServiceManagement.Service.BookingService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Endpoint for creating a new booking
    @PostMapping("/create")
    public ResponseEntity<BookingConfirmationDTO> createBooking(@RequestBody BookingRequestDTO bookingRequest, HttpSession session) {
        try {
            BookingConfirmationDTO bookingConfirmation = bookingService.createBooking(bookingRequest, session);
            return new ResponseEntity<>(bookingConfirmation, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
        	System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint for getting a booking by ID
    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingConfirmationDTO> getBookingById(@PathVariable int bookingId) {
        return bookingService.getBookingById(bookingId)
                .map(bookingConfirmation -> new ResponseEntity<>(bookingConfirmation, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
    @GetMapping("/my")
    public ResponseEntity<?> getMyBookings(HttpSession session) {
        try {
            List<BookingConfirmationDTO> bookings = bookingService.getBookingsByUser(session);

            return ResponseEntity.ok(bookings);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body("Unauthorized: User not logged in.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Something went wrong while fetching bookings.");
        }
    }

}

