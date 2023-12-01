package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.modificacion.TurnoModificacionDto;
import com.backend.clinicaOdontologica.dto.salida.PacienteSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.exception.ResourceNotFoundException;
import com.backend.clinicaOdontologica.repository.TurnoRepository;

import java.util.List;

public interface ITurnoService {

    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto);

    List<TurnoSalidaDto> listarTodosLosTurnos();

    void eliminarTurnoPorId(Long id) throws ResourceNotFoundException;

    TurnoSalidaDto buscarTurnoPorId(Long id) throws ResourceNotFoundException;

    TurnoSalidaDto actualizarTurno(TurnoModificacionDto turnoModificacionDto) throws ResourceNotFoundException;
}