package com.digital_booking.api_user.exceptions;

public class UserExists extends Exception{
    public UserExists(String message) {
        super(message);
    }
}
