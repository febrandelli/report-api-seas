package com.github.seas.reportapi.config.security.Service;

import com.github.seas.reportapi.domain.Usuario;
import com.github.seas.reportapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpringAuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usuario) {
        Optional<Usuario> user = userRepository.findByUserName(usuario);
        if (user.isPresent()) {
            return user.get();
        }

        throw new UsernameNotFoundException("Invalid credentials");
    }
}
