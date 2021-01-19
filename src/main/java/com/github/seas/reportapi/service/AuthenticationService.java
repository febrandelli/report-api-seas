package com.github.seas.reportapi.service;

import com.github.seas.reportapi.domain.User;
import com.github.seas.reportapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String usuario)   {
        Optional<User> user =  userRepository.findByUsuario(usuario);
        if (user.isPresent()){
            return user.get();
        }

        throw new UsernameNotFoundException("Invalid credentials");
    }
}
