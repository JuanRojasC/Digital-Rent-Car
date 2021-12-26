package com.digital_booking.api_products.repository;

import com.digital_booking.api_products.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Long> {

    @Query("FROM Booking b WHERE b.userId = ?1")
    Collection<Booking> findAllByUserId(Long id);

    @Query(value = "CALL findBooking(?1, ?2);", nativeQuery = true)
    Collection<Booking> findAllBetweenDateRange(Date checkIn, Date checkOut);
}
