package com.backend.clinicaOdontologica.repository;

import com.backend.clinicaOdontologica.model.Paciente;
import com.backend.clinicaOdontologica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    Optional<Turno> findById(Long id);
}
