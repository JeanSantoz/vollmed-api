package com.jeandev.programedic.controller;

import com.jeandev.programedic.dto.MedicoDto;
import com.jeandev.programedic.dto.MedicoResponseDto;
import com.jeandev.programedic.dto.MedicoUpdateDto;
import com.jeandev.programedic.entities.Medico;
import com.jeandev.programedic.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Page<MedicoResponseDto> findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination) {
        return medicoRepository.findAllByAtivoTrue(pagination).map(MedicoResponseDto::new);
    }

    @PutMapping
    @Transactional
    public void update(@Valid @RequestBody MedicoUpdateDto medicoUpdateDto){
        var medico = medicoRepository.getReferenceById(medicoUpdateDto.id());
        medico.update(medicoUpdateDto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.dasativar();
    }

}
