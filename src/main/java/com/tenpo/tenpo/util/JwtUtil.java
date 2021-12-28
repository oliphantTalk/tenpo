package com.tenpo.tenpo.util;

import com.nimbusds.oauth2.sdk.TokenResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static io.jsonwebtoken.io.Decoders.BASE64;
import static java.time.temporal.ChronoUnit.SECONDS;
import static org.springframework.util.StringUtils.hasText;

public class JwtUtil {

    private static final int JWT_TTL = 300; // SEG
    private static final String AUTH_HEADER = "Authorization";


    /**
     * @param ttl: Time to live of token
     * @param userId: Could be username or email
     * @param jwk: public key to chiper
     */
    public static String getJwt(final Integer ttl, String userId, String jwk) {
        Date now = new Date();
        Date expiration = Date.from(now.toInstant().plus(ttl != null ? ttl : JWT_TTL, SECONDS));
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(Keys.hmacShaKeyFor(BASE64.decode(jwk)))
                .compact();
    }

    public static String getTokenFromHeader(HttpServletRequest request) {
        String tokenHeader = request.getHeader(AUTH_HEADER);
        return removeBearerToToken(tokenHeader);
    }

    private static String removeBearerToToken(String token) {
        if (containBearer(token)) {
            return token.substring(START_TOKEN_INDEX);
        }
        return token;
    }

    private static boolean containBearer(String token) {
        return hasText(token) && token.startsWith(TOKEN_BEARER);
    }

    public TokenResponse generateTokenResponse() {
        String token = jwtGenerator.generate(AuthenticationService.getUsername(), jwtSignKey);
        return new TokenResponse(TOKEN_BEARER, token);
    }

    public boolean isValidToken(String token) {
        if (containBearer(token)) {
            token = removeBearerToToken(token);
        }
        return isValid(token, jwtSignKey);
    }

    public String getUsername(String token) {
        if (containBearer(token)) {
            token = removeBearerToToken(token);
        }
        return JwtTranslator.getUsername(token, jwtSignKey);
    }



}
