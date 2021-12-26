package com.digital_booking.api_products.service;

import com.digital_booking.api_products.dto.BookingDTO;
import com.digital_booking.api_products.dto.ProductDTO;
import com.digital_booking.api_products.exceptions.IncompleteData;
import com.digital_booking.api_products.exceptions.InvalidDateBooking;
import com.digital_booking.api_products.model.Booking;
import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.model.Product;
import com.digital_booking.api_products.repository.IBookingRepository;
import com.digital_booking.api_products.util.Log;
import com.digital_booking.api_products.vo.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j
@Service
public class BookingService {

    private IBookingRepository bookingRepository;
    private ProductService productService;
    private UserService userService;

    @Autowired
    public BookingService(IBookingRepository bookingRepository, ProductService productService, UserService userService) {
        this.bookingRepository = bookingRepository;
        this.productService = productService;
        this.userService = userService;
    }

    /*-------------------------------------------Save Booking--------------------------------------------------------*/

    public BookingDTO saveBooking(BookingDTO b) throws ResourceNotFound, InvalidDateBooking, IncompleteData {
        log.info(Log.formatLog("BOOKING-SERVICE-SAVING", "Guardando booking nueva"));
        if(b.getProduct().getId() == null) throw new IncompleteData("Booking product_id attribute cannot be null, please check you JSON and try again");
        if(b.getUser().getId() == null) throw new IncompleteData("Booking user_id attribute cannot be null, please check you JSON and try again");
        // Evita que se guarde un id no generado por la DB
        b.setId(null);
        // comprobacion del producto
        ProductDTO product = productService.findProductById(b.getProduct().getId());
        product.setBookings(new ArrayList<>());
        b.setProduct(product);
        // comprobacion del usuario
        User user = userService.getUser(b.getUser().getId());
        b.setUser(user);
        // comprobacion de las fechas
        Boolean startAfterTime = b.getTimeBooking().before(b.getStartTime());
        Boolean finishAfterStart = b.getStartTime().before(b.getFinishTime());
        if(!startAfterTime) throw new InvalidDateBooking("La fecha de reservacion no puede ser anterior a la fecha de checkIn");
        if(!finishAfterStart) throw new InvalidDateBooking("La fecha de checkOut no puede ser anterior a la fecha de checkIn");
        // guardado del producto
        Booking bookingResponse = bookingRepository.save(b.mapBooking());
        // retorno de producto
        b.setId(bookingResponse.getId());
        log.info(Log.formatLog("BOOKING-SERVICE-SUCCESS", "Booking con id " + product.getId() + " guardada"));
        return b;
    }

    /*-------------------------------------------Find By Id----------------------------------------------------------*/

    public BookingDTO findBookingById(Long id) throws ResourceNotFound {
        log.info(Log.formatLog("BOOKING-SERVICE-FINDING", "Buscando booking con id " + id));
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isEmpty()) {
            throw new ResourceNotFound("No se encontró booking con id " + id);
        } else {
            Booking bookingFound = booking.get();
            ProductDTO product = productService.findProductById(bookingFound.getProduct().getId());
            User user = userService.getUser(bookingFound.getUserId());
            BookingDTO bookingResponse = bookingFound.mapBookingDTO(product);
            bookingResponse.setProduct(product);
            bookingResponse.setUser(user);
            log.info(Log.formatLog("BOOKING-SERVICE-SUCCESS", "Booking con id " + id + " encontrada"));
            return bookingResponse;
        }
    }

    /*-------------------------------------------Find All Between Date Range----------------------------------------------------------*/

    public Collection<Booking> findBookingsBetweenDateRange(Date checkIn, Date checkOut){
        log.info(Log.formatLog("BOOKING-SERVICE-FINDING", "Buscando bookings entre las fechas: " + checkIn + " y " + checkOut));
        Collection<Booking> bookings = bookingRepository.findAllBetweenDateRange(checkIn, checkOut);
        log.info(Log.formatLog("BOOKING-SERVICE-SUCCESS", "Hay " + bookings.size() + " bookings entre las fechas: " + checkIn + " y " + checkOut));
        return bookings;
    }

    /*-------------------------------------------Update Booking-------------------------------------------*/

    public BookingDTO updateBooking(BookingDTO booking) throws ResourceNotFound, IncompleteData {
        log.info(Log.formatLog("PRODUCT-SERVICE-UPDATING", "Actualizando booking con id " + booking.getId()));
        if(booking.getId() == null) throw new IncompleteData("Booking id attribute cannot be null, please check you JSON and try again");
        if(booking.getProduct() == null) throw new IncompleteData("Booking product attribute cannot be null, please check you JSON and try again");
        // comprobacion del booking
        Booking bookingSaved = (Booking) checkBookingExistence(booking.getId(), true);
        if(bookingSaved == null) throw new ResourceNotFound("Booking con id " + booking.getId() + " no existe");
        // comprobacion del producto
        ProductDTO product = productService.findProductById(booking.getProduct().getId());
        // comprobacion del usuario
        User user = userService.getUser(bookingSaved.getUserId());
        // seteos de seguridad
        booking.setTimeBooking(bookingSaved.getTimeBooking());
        booking.setUser(user);
        booking.setProduct(product);
        Booking bookingUpdated = bookingRepository.save(booking.mapBooking());
        // retorno
        booking.setId(bookingUpdated.getId());
        log.info(Log.formatLog("BOOKING-SERVICE-SUCCESS", "Booking con id " + product.getId() + " actualizada"));
        return booking;
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteBookingById(Long id) throws ResourceNotFound {
        log.info(Log.formatLog("BOOKING-SERVICE-DELETING", "Eliminando booking con id " + id));
        if(checkBookingExistence(id, false) != null){
            bookingRepository.deleteById(id);
            log.info(Log.formatLog("BOOKING-SERVICE-SUCCESS", "Booking con id " + id + " eliminada"));
            return;
        }
        log.info(Log.formatLog("BOOKING-SERVICE-FAIL", "Booking con id " + id + " no existe"));
    }

    /*-------------------------------------------Delete All By Id-------------------------------------------*/

    public void deleteAllBookingsById(Collection<Long> bookingsIds) throws ResourceNotFound {
        log.info(Log.formatLog("BOOKING-SERVICE-DELETING", "Eliminando bookings con ids " + bookingsIds));
        try {
            bookingRepository.deleteAllById(bookingsIds);
        } catch (Exception e) {
            String id = e.getMessage().replaceAll("\\D+", "");
            throw new ResourceNotFound("ERROR 404: No se encontro la booking con id " + id + "\n           " + "Verifique los ids enviados");
        }
        log.info(Log.formatLog("BOOKING-SERVICE-SUCCESS", "Bookings con ids " + bookingsIds + " eliminadas"));
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<BookingDTO> findAllBookings() {
        log.info(Log.formatLog("BOOKING-SERVICE-FINDING", "Buscando todas las bookings"));
        Collection<BookingDTO> bookings = mapCollectionBookingToBookingDTO(bookingRepository.findAll());
        log.info(Log.formatLog("BOOKING-SERVICE-SUCCESS", "Todas las bookings han sido obtenidas"));
        return bookings;
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<BookingDTO> findAllBookingsById(Collection<Long> ids) {
        log.info(Log.formatLog("BOOKING-SERVICE-FINDING", "Buscando todas las bookings con ids " + ids));
        Collection<BookingDTO> bookings = mapCollectionBookingToBookingDTO(bookingRepository.findAllById(ids));
        log.info(Log.formatLog("BOOKING-SERVICE-SUCCESS", "Todas las bookings con ids " + ids +" han sido obtenidas"));
        return bookings;
    }

    /*-------------------------------------------Find All By User_Id-------------------------------------------*/

    public Collection<BookingDTO> findAllBookingsByUserId(Long userId) {
        log.info(Log.formatLog("BOOKING-SERVICE-FINDING", "Buscando todas las bookings del user_id " + userId));
        Collection<BookingDTO> bookings = mapCollectionBookingToBookingDTO(bookingRepository.findAllByUserId(userId));
        log.info(Log.formatLog("BOOKING-SERVICE-SUCCESS", "Todas las bookings del user_id " + userId +" han sido obtenidas"));
        return bookings;
    }

    /*-------------------------------------------Map Collection-------------------------------------------*/

    public Collection<BookingDTO> mapCollectionBookingToBookingDTO(Collection<Booking> bookings){
        Collection<BookingDTO> bookingsDTO = new ArrayList<>();
        Collection<Long> productsIds = new ArrayList<>();
        Collection<Long> userIds = new ArrayList<>();
        for(Booking booking : bookings){
            productsIds.add(booking.getProduct().getId());
            userIds.add((booking.getUserId()));
        }
        Map<Long, ProductDTO> products = productService.findAllProductsByIdMap(productsIds);
        Map<Long, User> users = userService.getAllUsersById(userIds);
        for(Booking booking : bookings){
            BookingDTO b = booking.mapBookingDTO(products.get(booking.getProduct().getId()));
            b.setUser(users.get(booking.getUserId()));
            bookingsDTO.add(b);
        }
        return bookingsDTO;
    }

    public Collection<BookingDTO> mapCollectionBookingToCollectionBookingDTO(Collection<Booking> bookings){
        Collection<BookingDTO> bookingsDTO = new ArrayList<>();
        Collection<Long> productsIds = new ArrayList<>();
        Collection<Long> userIds = new ArrayList<>();
        for(Booking booking : bookings){
            productsIds.add(booking.getProduct().getId());
            userIds.add((booking.getUserId()));
        }
        Map<Long, User> users = userService.getAllUsersById(userIds);
        for(Booking booking : bookings){
            /*product null because this method is used for returned the bookings of product*/
            BookingDTO b = booking.mapBookingDTO(null);
            b.setUser(users.get(booking.getUserId()));
            bookingsDTO.add(b);
        }
        return bookingsDTO;
    }

    /*-------------------------------------------Check and Security Data-------------------------------------------*/

    /*-------------------------------------------Check Booking Existence-------------------------------------------*/

    public Object checkBookingExistence(Long id, Boolean returnBooking){
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.get() != null){
            return returnBooking? booking.get() : true;
        }
        return null;
    }
}