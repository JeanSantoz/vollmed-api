package com.jeandev.programedic.dto;

import com.jeandev.programedic.entities.Paciente;
public record PacienteResponseDto(String nome, String cpf, String email) {

    public PacienteResponseDto(Paciente paciente){
        this(paciente.getNome(), paciente.getCpf(), paciente.getEmail());
    }
}
