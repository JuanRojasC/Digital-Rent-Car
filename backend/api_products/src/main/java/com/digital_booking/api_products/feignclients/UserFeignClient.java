package com.digital_booking.api_products.feignclients;

import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "users-service" /*, url = "http://localhost:9006"*/)
@RequestMapping("/users")
public interface UserFeignClient {

    @GetMapping("/find/{id}")
    User findUserById(@PathVariable Long id) throws ResourceNotFound;

    @GetMapping("/find/all")
    Collection<User> findAllUsers();

    @PostMapping("/find/ids")
    Collection<User> findUsersByIds(@RequestBody Collection<Long> usersId);

}
