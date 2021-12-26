package com.digital_booking.api_user.entity;

import com.digital_booking.api_user.dto.UserDTO;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "last_name", nullable = false)
    @NotNull
    private String lastName;

    @Column(name = "email", nullable = false)
    @NotNull
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull
    private String password;

    @Column(name = "verified", nullable = false)
    @NotNull
    private Integer verified;

    @ManyToOne
    private Role role;

    /*Map the User to DTO class*/
    public UserDTO mapUserDTO(){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(this.id);
        userDTO.setName(this.name);
        userDTO.setLastName(this.lastName);
        userDTO.setEmail(this.email);
        userDTO.setPassword(this.password);
        userDTO.setRole(role);
        return userDTO;
    }
}
