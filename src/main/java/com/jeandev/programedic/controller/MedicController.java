package com.jeandev.programedic.controller;

import com.jeandev.programedic.dto.MedicoDto;
import com.jeandev.programedic.dto.MedicoResponseDto;
import com.jeandev.programedic.dto.MedicoResponseUpdateDto;
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
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicController {

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity addMedico(@RequestBody @Valid MedicoDto medicoDto, UriComponentsBuilder uriBuilder){
        var medico = new Medico(medicoDto);

        medicoRepository.save(medico);

        var uri = uriBuilder.path("medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicoResponseUpdateDto(medico));
    }

    @GetMapping
    public ResponseEntity<Page<MedicoResponseDto>> findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination) {
        var page = medicoRepository.findAllByAtivoTrue(pagination).map(MedicoResponseDto::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public MedicoResponseDto findByIdn(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        return new MedicoResponseDto(medico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@Valid @RequestBody MedicoUpdateDto medicoUpdateDto){
        var medico = medicoRepository.getReferenceById(medicoUpdateDto.id());
        medico.update(medicoUpdateDto);
        return ResponseEntity.ok(new MedicoResponseUpdateDto(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.dasativar();
        return ResponseEntity.noContent().build();
    }

}
