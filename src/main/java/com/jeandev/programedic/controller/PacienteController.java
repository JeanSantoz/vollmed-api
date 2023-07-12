package com.jeandev.programedic.controller;

import com.jeandev.programedic.dto.MedicoDto;
import com.jeandev.programedic.dto.PacienteDto;
import com.jeandev.programedic.entities.Medico;
import com.jeandev.programedic.entities.Paciente;
import com.jeandev.programedic.repositories.MedicoRepository;
import com.jeandev.programedic.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
