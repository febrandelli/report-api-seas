package com.github.seas.reportapi.config.security.Service;

import com.github.seas.reportapi.domain.Usuario;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UserRepository userRepository;

    @Value("${forum.jwt.secret}")
    private String secret;

    @Value("${forum.jwt.expiration}")
    private String expiration;

    public String createToken(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();
        Date today = new Date();
        Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("API do SEAS")
                .setSubject(logado.getId().toString())
                .setIssuedAt(today)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Usuario getUserById(String token) throws NotFoundException {

        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        Long id = Long.parseLong(claims.getSubject());
        Optional<Usuario> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new NotFoundException("Usuario invalido");
    }
}
