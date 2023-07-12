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
        logradouro = enderecoDto.logradouro();
        bairro = enderecoDto.bairro();
        cep = enderecoDto.cep();
        cidade = enderecoDto.cidade();
        uf = enderecoDto.uf();
        numero = enderecoDto.numero();
        complemento = enderecoDto.complemento();
    }
}
