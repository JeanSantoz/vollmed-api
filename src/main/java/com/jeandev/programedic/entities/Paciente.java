package com.jeandev.programedic.entities;

import com.jeandev.programedic.dto.MedicoDto;
import com.jeandev.programedic.dto.PacienteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Paciente")
@Table(name = "Pacientes")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    @Embedded
    private Endereco endereco ;

    public Paciente(PacienteDto pacienteDto){
        nome = pacienteDto.nome();
        email = pacienteDto.email();
        cpf = pacienteDto.cpf();
        telefone = pacienteDto.telefone();
        endereco = new Endereco(pacienteDto.endereco());
    }

}
