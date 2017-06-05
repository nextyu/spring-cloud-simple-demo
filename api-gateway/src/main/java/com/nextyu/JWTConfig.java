package com.nextyu;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;

/**
 * created on 2017-06-05 17:23
 *
 * @author nextyu
 */
@Configuration
public class JWTConfig {

    @Bean
    public Algorithm algorithm() throws UnsupportedEncodingException {
        return Algorithm.HMAC256("secret");
    }

    @Bean
    public JWTVerifier verifier() throws UnsupportedEncodingException {
        return JWT.require(algorithm())
                .withIssuer("nextyu")
                .build();
    }
}
