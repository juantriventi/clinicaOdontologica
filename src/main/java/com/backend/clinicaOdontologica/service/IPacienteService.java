package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.entradaPaciente.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.salidaPaciente.PacienteSalidaDto;
public interface IPacienteService {

    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);
    PacienteSalidaDto buscarPacientePorId(Long id);

}
