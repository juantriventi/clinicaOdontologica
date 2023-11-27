package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.PacienteSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.model.Odontologo;
import com.backend.clinicaOdontologica.model.Paciente;
import com.backend.clinicaOdontologica.model.Turno;
import com.backend.clinicaOdontologica.repository.TurnoRepository;
import com.backend.clinicaOdontologica.service.ITurnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {
    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);

    private TurnoRepository turnoRepository;

    private ModelMapper modelMapper;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper) {
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
    }

    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turno){
        LOGGER.info("TurnoEntradaDTO: " + turno.toString());

        Turno turnoEntidad = modelMapper.map(turno, Turno.class);
        turnoEntidad.setPaciente(modelMapper.map(turno.getPaciente(), Paciente.class));
        turnoEntidad.setOdontologo(modelMapper.map(turno.getOdontologo(), Odontologo.class));
        Turno turnoAPersistir = turnoRepository.save(turnoEntidad);

        TurnoSalidaDto turnoSalidaDto = modelMapper.map(turnoAPersistir, TurnoSalidaDto.class);

        return turnoSalidaDto;
    }

    @Override
    public PacienteSalidaDto buscarTurnoPorId(Long id) {
        Optional<Turno> turnoOptional = turnoRepository.findById(id);
        TurnoSalidaDto turnoEncontrado = null;
    }

    @Override
    public List<PacienteSalidaDto> listarTurnos() {
        return null;
    }


}
