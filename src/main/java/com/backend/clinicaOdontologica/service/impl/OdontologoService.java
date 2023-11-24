package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.PacienteSalidaDto;
import com.backend.clinicaOdontologica.model.Domicilio;
import com.backend.clinicaOdontologica.model.Odontologo;
import com.backend.clinicaOdontologica.model.Paciente;
import com.backend.clinicaOdontologica.repository.OdontologoRepository;
import com.backend.clinicaOdontologica.service.IOdontologoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {
    private final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);

    private OdontologoRepository odontologoRepository;
    private ModelMapper modelMapper;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository, ModelMapper modelMapper) {
        this.odontologoRepository = odontologoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OdontologoSalidaDto> listarOdontologos() {
        return null;
    }

    public OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo) {

        LOGGER.info("OdontologoEntradaDTO: " + odontologo.toString());

        Odontologo odontologoEntidad = modelMapper.map(odontologo, Odontologo.class);

        //GUARDAMOS ODONTOLOGO
        Optional<Odontologo> odontologoOptional = Optional.of(odontologoRepository.save(odontologoEntidad));

        OdontologoSalidaDto odontologoSalidaDto = modelMapper.map(odontologoOptional, OdontologoSalidaDto.class);

        return odontologoSalidaDto;
    }


    public OdontologoSalidaDto buscarOdontologoPorId(Long id) {
        Optional<Odontologo> odontologoOptional = odontologoRepository.findById(id);
        OdontologoSalidaDto odontologoEncontrado = null;

        if (odontologoOptional.isPresent()) {
            Odontologo odontologoBuscado = odontologoOptional.get();
            odontologoEncontrado = modelMapper.map(odontologoBuscado, OdontologoSalidaDto.class);
        } else {
            LOGGER.error("Error al buscar odontologo");
        }
        return odontologoEncontrado;
    }

    @Override
    public void eliminarOdontologo(Long id) {

    }


}
