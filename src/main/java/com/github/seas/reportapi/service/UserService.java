package com.github.seas.reportapi.service;

import com.github.seas.reportapi.controller.form.UserCreateForm;
import com.github.seas.reportapi.controller.form.UserUpdateForm;
import com.github.seas.reportapi.domain.User;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final String NOT_FOUND_USER = "Usuario não encontrado.";

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User createUser(UserCreateForm userCreate){
        User user = new User();
        user.setEmail(userCreate.getEmail());
        user.setNomeCompleto(userCreate.getNomeCompleto());
        user.setUsuario(userCreate.getUsuario());
        user.setSenha(passwordEncoder.encode(userCreate.getSenha()));

        return userRepository.insert(user);
    }

    public User getUser(String usuario) throws NotFoundException {
        Optional<User> user = userRepository.findByUsuario(usuario);
        if (!user.isPresent()){
            throw new NotFoundException(NOT_FOUND_USER);
        }
        return user.get();
    }

    public User getUserById(String id) throws NotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()){
            throw new NotFoundException(NOT_FOUND_USER);
        }
        return user.get();
    }

    public User updateUser(UserUpdateForm userToUpdate) throws NotFoundException {
        Optional<User> user = userRepository.findById(userToUpdate.getId());
        if (!user.isPresent()){
            throw new NotFoundException(NOT_FOUND_USER);
        }
        return userRepository.save(userToUpdate.createUser(user.get(), passwordEncoder));
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }
}
