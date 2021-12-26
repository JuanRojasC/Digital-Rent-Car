package com.digital_booking.api_user.dto;

import com.digital_booking.api_user.entity.Role;
import com.digital_booking.api_user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    @JsonIgnoreProperties({"users", "id"})
    private Role role;

    /*Map the DTO to User class*/
    public User mapUser(){
        User user = new User();
        user.setId(this.id);
        user.setName(this.name);
        user.setLastName(this.lastName);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setRole(role);
        return user;
    }
}
