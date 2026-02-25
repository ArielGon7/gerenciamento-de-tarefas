package com.devariel.gerenciamento_de_tarefas.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TOKEN = 86400000;

    public static String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TOKEN))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String extractToken(String token){
        return Jwts.parser().setSigningKey(key).build()
                .parseClaimsJwt(token).getBody().getSubject();
    }

    public static boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(key).build().parseClaimsJwt(token);
            return true;
        }catch (JwtException e){
            return false;
        }
    }



}
