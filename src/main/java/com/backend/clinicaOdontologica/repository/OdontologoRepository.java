package com.backend.clinicaOdontologica.repository;

import com.backend.clinicaOdontologica.model.Odontologo;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OdontologoRepository {
    Optional<Odontologo> findById(Long id);

    Optional<Odontologo> save(Odontologo odontologo);
}
