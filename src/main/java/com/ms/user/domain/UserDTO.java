package com.ms.user.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank(message = "Nome não pode estar vazio.")
        String name,
        @NotBlank(message = "Email não pode estar vazio.")
        @Email
        String email
) {
}
