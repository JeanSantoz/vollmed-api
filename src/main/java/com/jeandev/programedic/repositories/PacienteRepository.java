package com.jeandev.programedic.repositories;

import com.jeandev.programedic.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
