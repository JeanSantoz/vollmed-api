package com.jeandev.programedic.dto;

import com.jeandev.programedic.entities.Medico;
import com.jeandev.programedic.entities.enums.Especialidade;

public record MedicoResponseDto(Long id, String nome, String crm, String email, Especialidade especialidade) {

    public MedicoResponseDto(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade());
    }
}
