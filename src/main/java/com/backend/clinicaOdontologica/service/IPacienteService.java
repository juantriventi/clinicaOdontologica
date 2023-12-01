package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.modificacion.PacienteModificacionDto;
import com.backend.clinicaOdontologica.dto.salida.PacienteSalidaDto;
import com.backend.clinicaOdontologica.exception.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {

    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);
    PacienteSalidaDto buscarPacientePorId(Long id) throws ResourceNotFoundException;

    List<PacienteSalidaDto> listarPacientes();

    void eliminarPaciente(Long id) throws ResourceNotFoundException;

    PacienteSalidaDto actualizarPaciente(PacienteModificacionDto pacienteModificacionDto) throws ResourceNotFoundException;
}
