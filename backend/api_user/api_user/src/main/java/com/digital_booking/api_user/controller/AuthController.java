package com.digital_booking.api_user.controller;

import com.digital_booking.api_user.dto.RequestDTO;
import com.digital_booking.api_user.dto.TokenDTO;
import com.digital_booking.api_user.dto.UserDTO;
import com.digital_booking.api_user.exceptions.IncompleteData;
import com.digital_booking.api_user.exceptions.ResourceNotFound;
import com.digital_booking.api_user.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO user) throws Exception {
        TokenDTO token = userService.login(user);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestParam String token, @RequestBody RequestDTO request) throws ResourceNotFound {
        TokenDTO tokenResponse = userService.validateToken(token, request);
        return ResponseEntity.ok(tokenResponse);
    }

    @GetMapping("/verify/{token}")
    public ModelAndView verifyAccount(@PathVariable String token) throws ResourceNotFound {
        if(userService.verifyAccount(token)){
            ModelAndView page = new ModelAndView();
            page.setViewName("account-verified");
            return page;
        }
        return null;
    }

    @PostMapping("/save/new")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO u) throws Exception {
        UserDTO user = userService.saveUser(u);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
