package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.controller.form.ResetPasswordRequest;
import com.github.seas.reportapi.controller.form.UserCreateForm;
import com.github.seas.reportapi.controller.dto.UserResponseDto;
import com.github.seas.reportapi.controller.form.UserUpdateForm;
import com.github.seas.reportapi.controller.response.ResetPasswordResponse;
import com.github.seas.reportapi.domain.Usuario;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
public class UserController implements UserDefinition{

    private final UserService userService;

    @CrossOrigin
    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        List<Usuario> response = userService.getAll();

        return new ResponseEntity<>(response.stream().map(UserResponseDto::new).collect(Collectors.toList()), HttpStatus.OK);
    }

	@CrossOrigin
    @GetMapping(value = "/{idUsuario}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long idUsuario) throws NotFoundException {
        Usuario response = userService.getUser(idUsuario);

        return new ResponseEntity<>(new UserResponseDto(response), HttpStatus.OK);
    }

	@CrossOrigin
    @PostMapping()
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserCreateForm userCreate) {
        Usuario user = userService.createUser(userCreate);

        return new ResponseEntity<>(new UserResponseDto(user), HttpStatus.CREATED);
    }

	@CrossOrigin
    @PutMapping()
    public ResponseEntity<UserResponseDto> updateUser(@Valid @RequestBody UserUpdateForm userUpdate) throws NotFoundException {
        Usuario user = userService.updateUser(userUpdate);

        return new ResponseEntity<>(new UserResponseDto(user), HttpStatus.OK);
    }

	@CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable Long id) throws NotFoundException {
        Usuario user = userService.getUserById(id);
        userService.deleteUser(id);

        return new ResponseEntity<>(new UserResponseDto(user), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/resetpassword")
    public ResponseEntity<ResetPasswordResponse> resetPassword(@RequestBody ResetPasswordRequest request) throws NotFoundException {
        return userService.resetPassword(request.getEmail());
    }
}
