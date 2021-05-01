package com.github.seas.reportapi.service;

import com.github.seas.reportapi.controller.form.UserCreateForm;
import com.github.seas.reportapi.controller.form.UserUpdateForm;
import com.github.seas.reportapi.domain.Perfil;
import com.github.seas.reportapi.domain.Usuario;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.repository.PerfilRepository;
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
    private final PerfilRepository perfilRepository;
    private final PasswordEncoder passwordEncoder;
    private static final String NOT_FOUND_USER = "Usuario não encontrado.";

    public List<Usuario> getAll() {
        return userRepository.findAll();
    }

    public Usuario createUser(UserCreateForm userCreate){
        Usuario user = new Usuario();
        user.setEmail(userCreate.getEmail());
        user.setNomeCompleto(userCreate.getNomeCompleto());
        user.setUserName(userCreate.getUsuario());
        user.setSenha(passwordEncoder.encode(userCreate.getSenha()));
        List<Perfil> perfis = perfilRepository.findAllById(userCreate.getPerfis());
        user.setPerfis(perfis);

        return userRepository.save(user);
    }

    public Usuario getUser(Long idUsuario) throws NotFoundException {
        Optional<Usuario> user = userRepository.findById(idUsuario);
        if (!user.isPresent()){
            throw new NotFoundException(NOT_FOUND_USER);
        }
        return user.get();
    }

    public Usuario getUserById(Long id) throws NotFoundException {
        Optional<Usuario> user = userRepository.findById(id);
        if (!user.isPresent()){
            throw new NotFoundException(NOT_FOUND_USER);
        }
        return user.get();
    }

    public Usuario updateUser(UserUpdateForm userToUpdate) throws NotFoundException {
        Optional<Usuario> user = userRepository.findById(userToUpdate.getId());
        if (!user.isPresent()){
            throw new NotFoundException(NOT_FOUND_USER);
        }
        return userRepository.save(userToUpdate.createUser(user.get(), passwordEncoder));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
