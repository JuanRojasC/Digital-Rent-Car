package com.digital_booking.api_products.service;

import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.feignclients.UserFeignClient;
import com.digital_booking.api_products.util.Log;
import com.digital_booking.api_products.vo.User;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@Log4j
public class UserService {

    private UserFeignClient userFeignClient;

    @Autowired
    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public User getUser(Long id){
        try{
            log.info(Log.formatLog("USER-SERVICE-FINDING", "Buscando user con id " + id));
            User user = userFeignClient.findUserById(id);
            log.info(Log.formatLog("USER-SERVICE-SUCCESS", "User con id " + id + " encontrado"));
            return user;
        }catch (Exception ex){
            log.info(Log.formatLog("**USER-SERVICE-FAIL**", ex.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<User> getAllUsers(){
        try{
            log.info(Log.formatLog("USERS-SERVICE-FINDING", "Buscando todos los users"));
            Collection<User> users = userFeignClient.findAllUsers();
            log.info(Log.formatLog("USER-SERVICE-SUCCESS", "Todos los users han sido obtenidos"));
            return users;
        }catch (Exception ex){
            log.info(Log.formatLog("**USER-SERVICE-FAIL**", ex.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Map<Long, User> getAllUsersById(Collection<Long> ids){
        try{
            log.info(Log.formatLog("USERS-SERVICE-FINDING", "Buscando todos los users con ids " + ids));
            Collection<User> users = userFeignClient.findUsersByIds(ids);
            Map<Long, User> usersMap = new HashMap<>();
            for(User u : users) usersMap.put(u.getId(), u);
            log.info(Log.formatLog("USERS-SERVICE-SUCCESS", "Todos los users con ids " + ids +" han sido obtenidos"));
            return usersMap;
        }catch (Exception ex){
            log.info(Log.formatLog("**USER-SERVICE-FAIL**", ex.getMessage()));
            return null;
        }
    }
}
