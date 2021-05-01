package com.github.seas.reportapi.config.security;

import com.github.seas.reportapi.domain.Usuario;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.config.security.Service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class AuthenticationViaTokenFilter extends OncePerRequestFilter {

    private final TokenService tokenService;

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = getToken(request);
        Boolean valid = tokenService.isTokenValid(token);
        if (Boolean.TRUE.equals(valid)) {
            authenticationClient(token);
        }
        filterChain.doFilter(request, response);
    }

    private void authenticationClient(String token) throws NotFoundException {
        Usuario usuario = tokenService.getUserById(token);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getPerfis());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }
}
