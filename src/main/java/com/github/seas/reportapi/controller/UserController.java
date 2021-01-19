package com.github.seas.reportapi.controller;

import com.github.seas.reportapi.controller.form.UserCreateForm;
import com.github.seas.reportapi.controller.dto.UserResponseDto;
import com.github.seas.reportapi.controller.form.UserUpdateForm;
import com.github.seas.reportapi.domain.User;
import com.github.seas.reportapi.exception.NotFoundException;
import com.github.seas.reportapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        List<User> response = userService.getAll();
        return new ResponseEntity(response.stream().map(UserResponseDto::new), HttpStatus.OK);
    }

    @GetMapping(value = "/{usuario}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable String usuario) throws NotFoundException {
        User response = userService.getUser(usuario);
        if (response.getId() == null){
            throw new NotFoundException("Usuario não encontrado.");
        }

        return new ResponseEntity<>(new UserResponseDto(response), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserCreateForm userCreate) {
        User user = userService.createUser(userCreate);
        return new ResponseEntity<>(new UserResponseDto(user), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<UserResponseDto> updateUser(@Valid @RequestBody UserUpdateForm userUpdate) throws NotFoundException {
        User user = userService.updateUser(userUpdate);
        return new ResponseEntity<>(new UserResponseDto(user), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable String id) throws NotFoundException {
        User user = userService.getUserById(id);
        userService.deleteUser(id);

        return new ResponseEntity<>(new UserResponseDto(user), HttpStatus.OK);
    }
}
