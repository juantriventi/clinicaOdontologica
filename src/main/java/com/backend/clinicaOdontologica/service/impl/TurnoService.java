package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.model.Odontologo;
import com.backend.clinicaOdontologica.model.Paciente;
import com.backend.clinicaOdontologica.model.Turno;
import com.backend.clinicaOdontologica.repository.OdontologoRepository;
import com.backend.clinicaOdontologica.repository.PacienteRepository;
import com.backend.clinicaOdontologica.repository.TurnoRepository;
import com.backend.clinicaOdontologica.service.ITurnoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {
    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);

    private TurnoRepository turnoRepository;

    private final OdontologoRepository odontologoRepository;
    private final PacienteRepository pacienteRepository;

    private ModelMapper modelMapper;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository, OdontologoRepository odontologoRepository, PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.turnoRepository = turnoRepository;
        this.odontologoRepository = odontologoRepository;
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) {
        if (turnoEntradaDto.getOdontologo() == null || turnoEntradaDto.getPaciente() == null || turnoEntradaDto.getFechaYhora() == null) {
            throw new IllegalArgumentException("No pueden haber campos vacios");
        }
        Turno turno = modelMapper.map(turnoEntradaDto, Turno.class);

        // defino entidades del repositorio
        Odontologo odontologo = odontologoRepository.findById((long) turnoEntradaDto.getOdontologo().getId()).orElse(null);
        Paciente paciente = pacienteRepository.findById(turnoEntradaDto.getPaciente().getId()).orElse(null);

        // hago las referencias
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);

        Turno turnoRegistrado = turnoRepository.save(turno);
        return modelMapper.map(turnoRegistrado, TurnoSalidaDto.class);
    }

    @Override
    public List<TurnoSalidaDto> listarTodosLosTurnos() {
        List<Turno> turnos = turnoRepository.findAll();
        return modelMapper.map(turnos, new TypeToken<List<TurnoSalidaDto>>() {}.getType());
    }

    @Override
    public void eliminarTurnoPorId(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public TurnoSalidaDto buscarTurnoPorId(Long id) {
        Turno turno = turnoRepository.findById(id).orElse(null);
        return modelMapper.map(turno, TurnoSalidaDto.class);
    }
}
