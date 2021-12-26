package com.digital_booking.api_user.controller;

import com.digital_booking.api_user.dto.UserDTO;
import com.digital_booking.api_user.exceptions.IncompleteData;
import com.digital_booking.api_user.exceptions.ResourceNotFound;
import com.digital_booking.api_user.exceptions.UserExists;
import com.digital_booking.api_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //POST REQUEST

    /*Get Users for each id in list*/
    @PostMapping("/find/ids")
    public ResponseEntity<?> findUsersByIds(@RequestBody Collection<Long> usersId){
        Collection<UserDTO> users = userService.findAllUsersById(usersId);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    /*Delete Users for each id in list*/
    @PostMapping("/delete/ids")
    public ResponseEntity<?> deleteUsersByIds(@RequestBody Collection<Long> usersIds) throws ResourceNotFound {
        userService.deleteAllUsersById(usersIds);
        return ResponseEntity.status(HttpStatus.OK).body("Todos los usuarios han sido eliminados");
    }

    /*------------------------------------------------------------------------------------------------------*/

    //GET REQUEST
    @GetMapping("/find/all")
    public ResponseEntity<?>findAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?>findUserById(@PathVariable Long id) throws ResourceNotFound{
        UserDTO user = userService.findUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/find/email/{email}")
    public ResponseEntity<?>findUserByEmail(@PathVariable String email) throws ResourceNotFound{
        UserDTO user = userService.findUserByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    /*------------------------------------------------------------------------------------------------------*/

    //PUT REQUEST
    @PutMapping("/update/user")
    public ResponseEntity<?>updateUser(@RequestBody UserDTO u) throws Exception {
        return ResponseEntity.ok(userService.updateUser(u));
    }

    /*------------------------------------------------------------------------------------------------------*/

    //DELETE REQUEST
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable Long id) throws ResourceNotFound{
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario Eliminado");
    }
}
