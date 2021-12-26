package com.digital_booking.api_products.controller;

import com.digital_booking.api_products.dto.BookingDTO;
import com.digital_booking.api_products.exceptions.IncompleteData;
import com.digital_booking.api_products.exceptions.InvalidDateBooking;
import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.service.BookingService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // POST REQUEST
    @CircuitBreaker(name = "usersServicesCB", fallbackMethod = "fallBackUsersServices")
    @PostMapping("/save/new")
    public ResponseEntity<?> saveBooking(@RequestBody BookingDTO b) throws ResourceNotFound, InvalidDateBooking, IncompleteData {
        BookingDTO booking = bookingService.saveBooking(b);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    /*Get Bookings for each id in list*/
    @CircuitBreaker(name = "usersServicesCB", fallbackMethod = "fallBackUsersServices")
    @PostMapping("/find/ids")
    public ResponseEntity<?> findBookingsByIds(@RequestBody Collection<Long> bookingsIds){
        Collection<BookingDTO> bookings = bookingService.findAllBookingsById(bookingsIds);
        return ResponseEntity.status(HttpStatus.OK).body(bookings);
    }

    /*Delete Bookings for each id in list*/
    @CircuitBreaker(name = "usersServicesCB", fallbackMethod = "fallBackUsersServices")
    @PostMapping("/delete/ids")
    public ResponseEntity<?> deleteBookingsByIds(@RequestBody Collection<Long> bookingsIds) throws ResourceNotFound {
        bookingService.deleteAllBookingsById(bookingsIds);
        return ResponseEntity.status(HttpStatus.OK).body("Todas las bookings han sido eliminadas");
    }

    /*------------------------------------------------------------------------------------------------------*/

    // GET REQUEST
    @CircuitBreaker(name = "usersServicesCB", fallbackMethod = "fallBackUsersServices")
    @GetMapping("/find/all")
    public ResponseEntity<?> findAllBookings(){
        return ResponseEntity.ok(bookingService.findAllBookings());
    }

    @CircuitBreaker(name = "usersServicesCB", fallbackMethod = "fallBackUsersServices")
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findBookingById(@PathVariable Long id) throws ResourceNotFound {
        BookingDTO booking = bookingService.findBookingById(id);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    @CircuitBreaker(name = "usersServicesCB", fallbackMethod = "fallBackUsersServices")
    @GetMapping("/find/user/{userId}")
    public ResponseEntity<?> findBookingsByUserId(@PathVariable Long userId){
        Collection<BookingDTO> bookings = bookingService.findAllBookingsByUserId(userId);
        return ResponseEntity.ok(bookings);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // PUT REQUEST
    @CircuitBreaker(name = "usersServicesCB", fallbackMethod = "fallBackUsersServices")
    @PutMapping("/update/booking")
    public ResponseEntity<?> updateBooking(@RequestBody BookingDTO b) throws ResourceNotFound, IncompleteData {
        return ResponseEntity.ok(bookingService.updateBooking(b));
    }

    /*------------------------------------------------------------------------------------------------------*/

    // DELETE REQUEST
    @CircuitBreaker(name = "usersServicesCB", fallbackMethod = "fallBackUsersServices")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable Long id) throws ResourceNotFound {
        bookingService.deleteBookingById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Booking Eliminada");
    }

    /*------------------------------------------------------------------------------------------------------*/
    // CIRCUIT BREAKER METHODS
    /*------------------------------------------------------------------------------------------------------*/

    public ResponseEntity<?> fallBackUsersServices(Exception ex){
        return ResponseEntity.ok("BOOKINGS-SERVICE: " + ex.getMessage() + ", please try again");
    }
}
