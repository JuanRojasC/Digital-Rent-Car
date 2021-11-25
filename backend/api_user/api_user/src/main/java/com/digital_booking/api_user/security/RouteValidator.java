package com.digital_booking.api_user.security;

import com.digital_booking.api_user.dto.RequestDTO;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.regex.Pattern;

@Component
@Data
public class RouteValidator {

    private List<RequestDTO> paths;

    public Boolean isAdminPath(RequestDTO request){
        return paths.stream().anyMatch(p
                -> Pattern.matches(p.getUri(), request.getUri()) && p.getMethod().equals(request.getMethod()));
    }

    public Boolean isUserPath(RequestDTO request){
        return paths.stream().anyMatch(p
                -> Pattern.matches(p.getUri(), request.getUri()) && p.getMethod().equals(request.getMethod()));
    }
}
