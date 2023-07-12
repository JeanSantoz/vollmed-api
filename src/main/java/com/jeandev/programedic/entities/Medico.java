package com.jeandev.programedic.entities;

import com.jeandev.programedic.dto.MedicoDto;
import com.jeandev.programedic.entities.enums.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Medico")
@Table(name = "Medicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private  String email;
    private  String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco ;

    public Medico(MedicoDto medicoDto){
        nome = medicoDto.nome();
        email = medicoDto.email();
        telefone = medicoDto.telefone();
        crm = medicoDto.crm();
        especialidade = medicoDto.especialidade();
        endereco = new Endereco(medicoDto.endereco());
    }

}
