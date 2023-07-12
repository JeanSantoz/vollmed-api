package com.jeandev.programedic.controller;

import com.jeandev.programedic.dto.MedicoDto;
import com.jeandev.programedic.entities.Medico;
import com.jeandev.programedic.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicController {

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void addMedico(@RequestBody @Valid MedicoDto medicoDto){
        medicoRepository.save(new Medico(medicoDto));
    }

}
