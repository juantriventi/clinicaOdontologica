package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entradaPaciente.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.salidaPaciente.PacienteSalidaDto;
import com.backend.clinicaOdontologica.model.Domicilio;
import com.backend.clinicaOdontologica.model.Paciente;
import com.backend.clinicaOdontologica.repository.PacienteRepository;
import com.backend.clinicaOdontologica.service.IPacienteService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Paciente pacienteEntidad = modelMapper.map(paciente, Paciente.class);

        // Mapeo manual del domicilio
        pacienteEntidad.setDomicilio(modelMapper.map(paciente.getDomicilioEntradaDto(), Domicilio.class));

        Paciente pacienteAPersistir = pacienteRepository.save(pacienteEntidad);

        PacienteSalidaDto pacienteSalidaDto = modelMapper.map(pacienteAPersistir, PacienteSalidaDto.class);

        return pacienteSalidaDto;
    }

    @Override
    public PacienteSalidaDto buscarPacientePorId(Long id) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        PacienteSalidaDto pacienteEncontrado = null;

        if (pacienteOptional.isPresent()) {
            Paciente pacienteBuscado = pacienteOptional.get();
            pacienteEncontrado = modelMapper.map(pacienteBuscado, PacienteSalidaDto.class);
        } else {
            LOGGER.error("Error al buscar paciente");
        }
        return pacienteEncontrado;
    }


}
