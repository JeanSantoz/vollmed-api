package com.jeandev.programedic.entities;

import com.jeandev.programedic.dto.EnderecoDto;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String  cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(EnderecoDto enderecoDto) {
        this.logradouro = enderecoDto.logradouro();
        this.bairro = enderecoDto.bairro();
        this.cep = enderecoDto.cep();
        this.cidade = enderecoDto.cidade();
        this.uf = enderecoDto.uf();
        this.numero = enderecoDto.numero();
        this.complemento = enderecoDto.complemento();
    }
    public void update(EnderecoDto enderecoDto) {

        if(enderecoDto.logradouro() != null){
            this.logradouro = enderecoDto.logradouro();
        }

        if(enderecoDto.bairro() != null){
            this.bairro = enderecoDto.bairro();
        }

        if(enderecoDto.cep() != null){
            this.cep = enderecoDto.cep();
        }

        if(enderecoDto.cidade() != null){
            this.cidade = enderecoDto.cidade();
        }

        if(enderecoDto.uf() != null){
            this.uf = enderecoDto.uf();
        }

        if(enderecoDto.numero() != null){
            this.numero = enderecoDto.numero();
        }

        if(enderecoDto.complemento() != null){
            this.complemento = enderecoDto.complemento();
        }


    }


}
