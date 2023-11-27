package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.PacienteSalidaDto;

import java.util.List;

public interface ITurnoService {

    PacienteSalidaDto registrarTurno(TurnoEntradaDto turno);
    PacienteSalidaDto buscarTurnoPorId(Long id);

    List<PacienteSalidaDto> listarTurnos();
}
