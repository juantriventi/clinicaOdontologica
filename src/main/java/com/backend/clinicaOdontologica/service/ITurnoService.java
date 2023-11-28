package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.TurnoSalidaDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ITurnoService {

    TurnoSalidaDto programarTurno(Long pacienteId, Long odontologoId, LocalDateTime fecha);

    List<TurnoSalidaDto> listarTurnos();

    void cancelarTurno(Long turnoId);

    TurnoSalidaDto programarTurno(TurnoEntradaDto turnoEntradaDto);
}
