package com.backend.clinicaOdontologica.service;

import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.modificacion.OdontologoModificacionDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.exception.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {
    List<OdontologoSalidaDto> listarOdontologos();

    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

    OdontologoSalidaDto buscarOdontologoPorId(Long id);

    void eliminarOdontologo(Long id) throws ResourceNotFoundException;

   OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionDto odontologoModificacionDto) throws ResourceNotFoundException;
}
