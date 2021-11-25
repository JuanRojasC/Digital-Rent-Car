package com.digital_booking.api_user.dto;

import com.digital_booking.api_user.entity.User;
import lombok.Data;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    /*Map the DTO to User class*/
    public User mapUser(){
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setPassword(this.password);
        return user;
    }
}
