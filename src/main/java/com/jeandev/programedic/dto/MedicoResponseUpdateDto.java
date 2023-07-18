package com.jeandev.programedic.dto;
import com.jeandev.programedic.entities.Medico;
import com.jeandev.programedic.entities.enums.Especialidade;

public record MedicoResponseUpdateDto(

        Long id,
        String nome,
        String crm,
        String email,
        String telefone,
        Especialidade especialidade



) {
    public MedicoResponseUpdateDto(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getTelefone(), medico.getEspecialidade());
    }

}
