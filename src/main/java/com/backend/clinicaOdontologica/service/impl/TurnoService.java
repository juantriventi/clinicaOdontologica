package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.PacienteSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.model.Odontologo;
import com.backend.clinicaOdontologica.model.Paciente;
import com.backend.clinicaOdontologica.model.Turno;
import com.backend.clinicaOdontologica.repository.TurnoRepository;
import com.backend.clinicaOdontologica.service.ITurnoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurnoService implements ITurnoService {

    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);

    private final TurnoRepository turnoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper) {
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TurnoSalidaDto programarTurno(TurnoEntradaDto turnoEntradaDto) {
        LOGGER.info("Programando turno para la fecha y hora: {}", turnoEntradaDto.getFechaYHora());

        // Mapeo de TurnoEntradaDto a Turno
        Turno turno = modelMapper.map(turnoEntradaDto, Turno.class);

        // Guardar el turno en la base de datos
        Turno turnoProgramado = turnoRepository.save(turno);

        // Mapeo de Turno a TurnoSalidaDto
        TurnoSalidaDto turnoSalidaDto = modelMapper.map(turnoProgramado, TurnoSalidaDto.class);

        // También mapeamos manualmente las propiedades necesarias
        turnoSalidaDto.setFechaYHora(turnoProgramado.getFechaYHora());
        turnoSalidaDto.setOdontologo(modelMapper.map(turnoProgramado.getOdontologo(), OdontologoSalidaDto.class));
        turnoSalidaDto.setPaciente(modelMapper.map(turnoProgramado.getPaciente(), PacienteSalidaDto.class));

        LOGGER.info("Turno programado exitosamente. ID del turno: {}", turnoSalidaDto.getId());

        // Devolver el turno programado
        return turnoSalidaDto;
    }


    @Override
    public TurnoSalidaDto programarTurno(Long pacienteId, Long odontologoId, LocalDateTime fecha) {
        return null;
    }

    @Override
    public List<TurnoSalidaDto> listarTurnos() {
        return turnoRepository.findAll().stream()
                .map(turno -> modelMapper.map(turno, TurnoSalidaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void cancelarTurno(Long turnoId) {
        turnoRepository.deleteById(turnoId);
    }
}
