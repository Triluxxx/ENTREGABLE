package com.project.lab_clinico.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private final String SECRET_KEY = "d35df96f52a7424ba7ecf6ccba9c89b6bc2a4c1e04f6475b9d310cfaa2a7d223"; // cámbiala por una más segura
    private final long EXPIRATION_MS = 86400000; // 1 día

    public String generarToken(String correo) {
        return Jwts.builder()
                .setSubject(correo)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(getFirma(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String extraerCorreo(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getFirma())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(getFirma()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
    private Key getFirma() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }
}

