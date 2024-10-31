package com.ms.user.controllers;

import com.ms.user.domain.UserDTO;
import com.ms.user.domain.UserModel;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody @Valid UserDTO userDTO) {
        UserModel userSaved = userService.save(userDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userSaved.getId())
                .toUri();
        return ResponseEntity.created(location).body(userSaved);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserModel> getUser(@PathVariable UUID id) {
        UserModel user = userService.getById(id);
        return ResponseEntity.ok().body(user);
    }
}
