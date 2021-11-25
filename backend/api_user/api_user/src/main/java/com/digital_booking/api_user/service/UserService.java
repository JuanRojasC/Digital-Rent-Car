package com.digital_booking.api_user.service;


import com.digital_booking.api_user.dto.RequestDTO;
import com.digital_booking.api_user.dto.TokenDTO;
import com.digital_booking.api_user.dto.UserDTO;
import com.digital_booking.api_user.entity.Role;
import com.digital_booking.api_user.entity.User;
import com.digital_booking.api_user.exceptions.IncompleteData;
import com.digital_booking.api_user.exceptions.ResourceNotFound;
import com.digital_booking.api_user.exceptions.UserExists;
import com.digital_booking.api_user.repository.IUserRepository;
import com.digital_booking.api_user.security.JwtProvider;
import com.digital_booking.api_user.util.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j
@Service
public class UserService {

    private IUserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private JwtProvider jwtProvider;

    @Autowired
    public UserService(IUserRepository userRepository, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    /*-------------------------------------------Login-------------------------------------------*/

    public TokenDTO login(UserDTO user) throws IncompleteData, ResourceNotFound {
        /*Check if contains email and password*/
        if(user.getEmail() == null || user.getPassword() == null) throw new IncompleteData("Invalid credentials, email and password cannot be null, please check your JSON and try again");
        log.info(Log.formatLog("USER-SERVICE-LOGIN", "Iniciando sesion usuario " + user.getEmail()));
        /*Find the userName in DB*/
        User userFound = userRepository.findUserByEmail(user.getEmail()).get();
        /*Check the existence of user and if the password are correct*/
        if(userFound == null || !passwordEncoder.matches(user.getPassword(), userFound != null? userFound.getPassword() : null)){
            log.info(Log.formatLog("USER-SERVICE-SUCCESS", "Usuario " + user.getEmail() + " ingreso credenciales invalidas"));
            throw new ResourceNotFound("Invalid credentials, email or password are incorrect!!");
        }
        /*If password are correct and user exists, return the token*/
        TokenDTO token = TokenDTO.builder().status(200).message("Logged").jwt(jwtProvider.createToken(userFound)).build();
        log.info(Log.formatLog("USER-SERVICE-SUCCESS", "Usuario " + user.getEmail() + " ha iniciado sesion"));
        return token;
    }

    /*-------------------------------------------Request a service-------------------------------------------*/

    public TokenDTO validateToken(String tokenToValidate, RequestDTO request) throws ResourceNotFound {
        /*Check if contains email and password*/
        log.info(Log.formatLog("USER-SERVICE-VALIDATE", "Validando token " + tokenToValidate));
        if(!jwtProvider.validateToken(tokenToValidate, request)){
            log.info(Log.formatLog("USER-SERVICE-SUCCESS", "Token " + tokenToValidate + " invalidado"));
            throw new ResourceNotFound("Token invalid");
        }
        /*If token is valid check if user exists in DB*/
        Optional<User> userExists = userRepository.findUserByEmail(jwtProvider.getUserEmailFromToken(tokenToValidate));
        if(userExists.isEmpty())
            throw new ResourceNotFound("User does not exists");
        TokenDTO token = TokenDTO.builder().status(200).message("validated").jwt(tokenToValidate).build();
        log.info(Log.formatLog("USER-SERVICE-SUCCESS", "Token " + tokenToValidate + " validado"));
        return token;
    }

    /*-------------------------------------------Save User-------------------------------------------*/

    public UserDTO saveUser(UserDTO userToSave) throws IncompleteData, UserExists {
        log.info(Log.formatLog("USER-SERVICE-SAVING", "Guardando nuevo user"));
        // check the attributes
        checkAttributesUser(userToSave);
        // check if exists a user registered with that email
        if(checkUserNameExistence(userToSave.getEmail())) throw new UserExists("This email is being used, try other");
        // Evita que se guarde un id no generado por la DB
        userToSave.setId(null);
        // Encoder the password
        String password = passwordEncoder.encode(userToSave.getPassword());
        userToSave.setPassword(password);
        // set Role for default
        User userMapped = userToSave.mapUser();
        userMapped.setRole(Role.builder().id(3L).build());
        // Guardado del usuario
        User user = userRepository.save(userMapped);
        // Retorno de usuario
        UserDTO userResponse = user.mapUserDTO();
        // Set the password to "" for the return
        userResponse.setPassword("");
        log.info(Log.formatLog("USER-SERVICE-SUCCESS", "User con id " + user.getId() + " guardado"));
        return userResponse;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public UserDTO findUserById(Long id) throws ResourceNotFound {
        log.info(Log.formatLog("USER-SERVICE-FINDING", "Buscando user con id " + id));
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            log.info(Log.formatLog("USER-SERVICE-SUCCESS", "User con id " + id + " no fue encontrado"));
            throw new ResourceNotFound("No se encontro el user con id: " + id);
        }else{
            UserDTO userResponse = user.get().mapUserDTO();
            log.info(Log.formatLog("USER-SERVICE-SUCCESS", "User con id " + id + " encontrado"));
            return userResponse;
        }
    }

    /*-------------------------------------------Find By Email-------------------------------------------*/

    public UserDTO findUserByEmail(String email) throws ResourceNotFound {
        log.info(Log.formatLog("USER-SERVICE-FINDING", "Buscando user con email " + email));
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isEmpty()){
            throw new ResourceNotFound("No se encontro el user con email: " + email);
        }else{
            UserDTO userResponse = user.get().mapUserDTO();
            log.info(Log.formatLog("USER-SERVICE-SUCCESS", "User con email " + email + " encontrado"));
            return userResponse;
        }
    }

    /*-------------------------------------------Update User-------------------------------------------*/

    public UserDTO updateUser(UserDTO user) throws ResourceNotFound, IncompleteData, UserExists {
        log.info(Log.formatLog("USER-SERVICE-UPDATING", "Actualizando user con id " + user.getId()));
        if (user.getId() == null) throw new IncompleteData("User id attribute cannot be null, please check your JSON and try again");
        // check if exists a user registered with that email
        if(checkUserNameExistence(user.getEmail())) throw new UserExists("This email is being used, try other");
        // check attributes of user
        checkAttributesUser(user);
        // Comprobacion del user
        if(checkUserExistence(user.getId(),true) == null) throw new ResourceNotFound("User con id " + user.getId() + " no existe");
        // seteos de seguridad
        User userUpdate = userRepository.save(user.mapUser());
        UserDTO userResponse = userUpdate.mapUserDTO();
        log.info(Log.formatLog("USER-SERVICE-SUCCESS", "User con id " + user.getId() + " actualizado"));
        return userResponse;
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteUserById(Long id) throws ResourceNotFound{
        log.info(Log.formatLog("USER-SERVICE-DELETING", "Eliminando user con id " + id));
        if (checkUserExistence(id,false) != null){
            userRepository.deleteById(id);
            log.info(Log.formatLog("USER-SERVICE-SUCCESS", "User con id " + id + " eliminado"));
            return;
        }
        log.info(Log.formatLog("USER-SERVICE-SUCCESS", "User con id " + id + " no existe"));
    }

    /*-------------------------------------------Delete All By Id-------------------------------------------*/

    public void deleteAllUsersById(Collection<Long> ids) throws ResourceNotFound {
        log.info(Log.formatLog("USER-SERVICE-DELETING", "Eliminando users con ids " + ids));
        try {
            userRepository.deleteAllById(ids);
        }catch (Exception e){
            String id = e.getMessage().replaceAll("\\D+", "");
            throw new ResourceNotFound("ERROR 404: No se encontro al user con id " + id + "\n           " + "Verifique los ids enviados");
        }
        log.info(Log.formatLog("USER-SERVICE-SUCCESS", "Users con ids " + ids + " eliminadas"));
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<UserDTO>findAllUsers(){
        log.info(Log.formatLog("USERS-SERVICE-FINDING", "Buscando todos los users"));
        Collection<UserDTO> users = mapCollectionUserToUserDTO(userRepository.findAll());
        log.info(Log.formatLog("USER-SERVICE-SUCCESS", "Todos los users han sido obtenidos"));
        return users;
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<UserDTO> findAllUsersById(Collection<Long> ids){
        log.info(Log.formatLog("USERS-SERVICE-FINDING", "Buscando todos los users con ids " + ids));
        Collection<UserDTO> users = mapCollectionUserToUserDTO(userRepository.findAllById(ids));
        log.info(Log.formatLog("USERS-SERVICE-SUCCESS", "Todos los users con ids " + ids +" han sido obtenidos"));
        return users;
    }

    /*-------------------------------------------Map Collection-------------------------------------------*/

    public Collection<UserDTO> mapCollectionUserToUserDTO(Collection<User> users){
        Collection<UserDTO> usersDTO = new ArrayList<>();
        for(User user : users){
            UserDTO u = user.mapUserDTO();
            usersDTO.add(u);
        }
        return usersDTO;
    }

    /*-------------------------------------------Check and Security Data-------------------------------------------*/

    /*-------------------------------------------Check User Existence By Id-------------------------------------------*/

    public Object checkUserExistence(Long id, Boolean returnUser){
        Optional<User> user = userRepository.findById(id);
        if(user.get() != null){
            return returnUser? user.get() : true;
        }
        return null;
    }

    /*-------------------------------------------Check User Existence By Email-------------------------------------------*/

    public Boolean checkUserNameExistence(String userName){
        Optional<User> user = userRepository.findUserByEmail(userName);
        if(!user.isEmpty()){
            return true;
        }
        return false;
    }

    /*-------------------------------------------Check User Existence By Email-------------------------------------------*/

    public void checkAttributesUser(UserDTO user) throws IncompleteData {
        if(user.getName() == null ||  user.getName().trim().isEmpty())
            throw new IncompleteData("User name attribute cannot be null, please check your JSON and try again");
        else if(user.getLastName() == null ||  user.getLastName().trim().isEmpty())
            throw new IncompleteData("User lastName attribute cannot be null, please check your JSON and try again");
        else if(user.getEmail() == null || user.getEmail().trim().isEmpty())
            throw new IncompleteData(("User email attribute cannot be null, please check your JSON and try again"));
        else if(user.getPassword() == null || user.getPassword().trim().isEmpty())
            throw new IncompleteData(("User password attribute cannot be null, please check your JSON and try again"));
    }
}