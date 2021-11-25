package com.digital_booking.api_user.security;

import com.digital_booking.api_user.dto.RequestDTO;
import com.digital_booking.api_user.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    @Qualifier("adminRouteValidator")
    private RouteValidator adminRouteValidator;

    @Autowired
    @Qualifier("userRouteValidator")
    private RouteValidator userRouteValidator;

    @PostConstruct
    protected void init(){
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    /*Create the token*/
    public String createToken(User user){
        Map<String, Object> claims = new HashMap<>();
        claims = Jwts.claims().setSubject(user.getEmail());
        claims.put("id", user.getId());
        claims.put("role", user.getRole().getName());
        Date now = new Date();
        Date exp = new Date(now.getTime() + 7200000);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /*Validate the token*/
    public Boolean validateToken(String token, RequestDTO request){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            String role = (String) Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("role");
            switch (role){
                case "admin":
                    return !adminRouteValidator.isAdminPath(request);
                case "user":
                    return !userRouteValidator.isUserPath(request);
                default:
                    return false;
            }
        }catch (Exception ex){
            return false;
        }
    }

    /*Get userName in this case email from the token*/
    public String getUserEmailFromToken(String token){
        try{
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        }catch (Exception ex){
            return "Invalid Token";
        }
    }

    public Long getUserIdFromToken(String token){
        try{
            return (Long) Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("id");
        }catch (Exception ex){
            return null;
        }
    }

}
