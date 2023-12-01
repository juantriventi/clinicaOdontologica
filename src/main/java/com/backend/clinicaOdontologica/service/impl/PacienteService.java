package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.modificacion.PacienteModificacionDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.PacienteSalidaDto;
import com.backend.clinicaOdontologica.exception.ResourceNotFoundException;
import com.backend.clinicaOdontologica.model.Domicilio;
import com.backend.clinicaOdontologica.model.Odontologo;
import com.backend.clinicaOdontologica.model.Paciente;
import com.backend.clinicaOdontologica.repository.PacienteRepository;
import com.backend.clinicaOdontologica.service.IPacienteService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    private final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);

    private PacienteRepository pacienteRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    public PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente) {

        LOGGER.info("PacienteEntradaDTO: " + paciente.toString());

        Paciente pacienteEntidad = mapDTOAEntidad(paciente);

        // Mapeo manual del domicilio
        pacienteEntidad.setDomicilio(modelMapper.map(paciente.getDomicilioEntradaDto(), Domicilio.class));

        Paciente pacienteAPersistir = pacienteRepository.save(pacienteEntidad);

        PacienteSalidaDto pacienteSalidaDto = modelMapper.map(pacienteAPersistir, PacienteSalidaDto.class);

        return pacienteSalidaDto;
    }

    @Override
    public PacienteSalidaDto buscarPacientePorId(Long id) throws ResourceNotFoundException {
        Paciente pacienteABuscar = pacienteRepository.findById(id).orElse(null);
        PacienteSalidaDto pacienteEncontrado = null;

        if (pacienteABuscar!=null){
            LOGGER.warn("paciente encontrado: {}", pacienteABuscar);
            pacienteEncontrado = modelMapper.map(pacienteABuscar, PacienteSalidaDto.class);
        } else {
            LOGGER.error("Error al buscar paciente");
            throw new ResourceNotFoundException("No se ha encontrado el paciente con id " + id);
        }
        return pacienteEncontrado;
    }
    public List<PacienteSalidaDto> listarPacientes() {
        List<PacienteSalidaDto> pacientesSalidaDto = pacienteRepository.findAll()
                .stream()
                .map(paciente -> modelMapper.map(paciente, PacienteSalidaDto.class))
                .toList();

        if (LOGGER.isInfoEnabled())
            LOGGER.info("Listado de todos los pacientes: {}", pacientesSalidaDto);

        return pacientesSalidaDto;
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if (pacienteRepository.findById(id).orElse(null) != null) {
            pacienteRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el paciente con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el paciente con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el paciente con id " + id);
        }

    }

    @Override
    public PacienteSalidaDto actualizarPaciente(PacienteModificacionDto pacienteModificacionDto) throws ResourceNotFoundException {
        Paciente pacienteRecibido = modelMapper.map(pacienteModificacionDto, Paciente.class);
        Paciente pacienteActualizar = pacienteRepository.findById(pacienteModificacionDto.getId()).orElse(null);
        PacienteSalidaDto pacienteSalida = null;
        if (pacienteActualizar != null) {

            //actualizamos paciente encontrado con los datos del recibido y guardamos nuevamente
            pacienteActualizar = pacienteRecibido;
            pacienteRepository.save(pacienteActualizar);

            pacienteSalida = modelMapper.map(pacienteActualizar, PacienteSalidaDto.class);

            LOGGER.warn("Paciente actualizado: {}", pacienteSalida);
        }
        else{
            LOGGER.error("Error al actualizar paciente, no se encontró registrado");
            throw new ResourceNotFoundException("Error al actualizar paciente, no se encontró registrado");
        }
        return pacienteSalida;
    }

    private Paciente mapDTOAEntidad(PacienteEntradaDto pacienteEntradaDto) {
        return modelMapper.map(pacienteEntradaDto, Paciente.class);
    }

}
