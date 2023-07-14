package com.jeandev.programedic.controller;

import com.jeandev.programedic.dto.MedicoDto;
import com.jeandev.programedic.dto.PacienteDto;
import com.jeandev.programedic.dto.PacienteResponseDto;
import com.jeandev.programedic.entities.Medico;
import com.jeandev.programedic.entities.Paciente;
import com.jeandev.programedic.repositories.MedicoRepository;
import com.jeandev.programedic.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void addPaciente(@RequestBody @Valid PacienteDto pacienteDto){
        pacienteRepository.save(new Paciente(pacienteDto));
    }

    @GetMapping
    public Page<PacienteResponseDto> findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination){
        return pacienteRepository.findAll(pagination).map(PacienteResponseDto::new);
    }



}
