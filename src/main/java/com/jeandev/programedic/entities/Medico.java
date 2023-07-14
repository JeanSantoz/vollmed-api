package com.jeandev.programedic.entities;

import com.jeandev.programedic.dto.MedicoDto;
import com.jeandev.programedic.dto.MedicoUpdateDto;
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
    private  boolean ativo;
    private String nome;
    private  String email;
    private  String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco ;

    public Medico(MedicoDto medicoDto){
        this.id = null;
        this.nome = medicoDto.nome();
        this.email = medicoDto.email();
        this.telefone = medicoDto.telefone();
        this.crm = medicoDto.crm();
        this.especialidade = medicoDto.especialidade();
        this.endereco = new Endereco(medicoDto.endereco());
        this.ativo = true;
    }
    public void update(MedicoUpdateDto medicoUpdateDto){

        if(medicoUpdateDto.nome() != null){
            this.nome = medicoUpdateDto.nome();
        }

        if(medicoUpdateDto.email() != null) {
            this.email = medicoUpdateDto.email();
        }

        if(medicoUpdateDto.endereco() != null) {
            this.endereco.update(medicoUpdateDto.endereco());
        }
    }

    public void dasativar(){
        this.ativo = false;
    }



}
