package com.digital_booking.gateway_service.config;

import com.digital_booking.gateway_service.dto.RequestDTO;
import com.digital_booking.gateway_service.dto.TokenDTO;
import com.digital_booking.gateway_service.util.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Log4j
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    private WebClient.Builder webClient;

    public AuthFilter(WebClient.Builder webClient) {
        super(Config.class);
        this.webClient = webClient;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (((exchange, chain) -> {
            if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                log.info(Log.formatLog("GATEWAY-SERVICE-SUCCESS", "Request without Header"));
                return onError(exchange, HttpStatus.BAD_REQUEST);
            }
            String tokenHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            if(tokenHeader == null){
                log.info(Log.formatLog("GATEWAY-SERVICE-SUCCESS", "Request without Token"));
                return onError(exchange, HttpStatus.BAD_REQUEST);
            }
            try{
                return webClient.build()
                        .post()
                        .uri("http://users-service/auth/validate?token=" + tokenHeader)
                        .bodyValue(new RequestDTO(exchange.getRequest().getPath().toString(), exchange.getRequest().getMethod().toString()))
                        .retrieve().bodyToMono(TokenDTO.class)
                        .map(t -> {
                            t.getJwt();
                            return exchange;
                        }).flatMap(chain::filter);
            }catch (Exception ex){
                log.info(Log.formatLog("**GATEWAY-SERVICE-FAIL**", ex.getMessage()));
                return onError(exchange, HttpStatus.BAD_REQUEST);
            }
        }));
    }

    public Mono<Void> onError(ServerWebExchange exchange, HttpStatus status){
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(status);
        return response.setComplete();
    }

    public static  class Config{

    }
}
