package com.github.seas.reportapi.service;

import com.github.seas.reportapi.controller.form.UserCreateForm;
import com.github.seas.reportapi.controller.form.UserUpdateForm;
import com.github.seas.reportapi.domain.Perfil;
import com.github.seas.reportapi.domain.Usuario;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.repository.PerfilRepository;
import com.github.seas.reportapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
    private final PasswordEncoder passwordEncoder;
    private static final String NOT_FOUND_USER = "Usuario não encontrado.";

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario createUser(UserCreateForm userCreate){
        Usuario user = new Usuario();
        user.setEmail(userCreate.getEmail());
        user.setNomeCompleto(userCreate.getNomeCompleto());
        user.setUsername(userCreate.getUsuario());
        user.setSenha(passwordEncoder.encode(userCreate.getSenha()));
        List<Perfil> perfis = perfilRepository.findAllById(userCreate.getPerfis());
        user.setPerfis(perfis);

        return usuarioRepository.save(user);
    }

    public Usuario getUser(Long idUsuario) throws NotFoundException {
        Optional<Usuario> user = usuarioRepository.findById(idUsuario);
        if (!user.isPresent()){
            throw new NotFoundException(NOT_FOUND_USER);
        }
        return user.get();
    }

    public Usuario getUserById(Long id) throws NotFoundException {
        Optional<Usuario> user = usuarioRepository.findById(id);
        if (!user.isPresent()){
            throw new NotFoundException(NOT_FOUND_USER);
        }
        return user.get();
    }

    public Usuario updateUser(UserUpdateForm userToUpdate) throws NotFoundException {
        Optional<Usuario> user = usuarioRepository.findById(userToUpdate.getId());
        if (!user.isPresent()){
            throw new NotFoundException(NOT_FOUND_USER);
        }
        return usuarioRepository.save(userToUpdate.createUser(user.get(), passwordEncoder));
    }

    public void deleteUser(Long id){
        usuarioRepository.deleteById(id);
    }
}
