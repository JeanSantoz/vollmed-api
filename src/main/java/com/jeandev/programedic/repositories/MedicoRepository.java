package com.jeandev.programedic.repositories;

import com.jeandev.programedic.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
