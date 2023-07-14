package com.jeandev.programedic.dto;

import com.jeandev.programedic.entities.enums.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoUpdateDto(
        @NotNull
        Long id,
        String nome,

        String email,

        EnderecoDto endereco) {
}