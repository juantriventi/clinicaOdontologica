package com.backend.clinicaOdontologica.service.impl;

import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.modificacion.OdontologoModificacionDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.PacienteSalidaDto;
import com.backend.clinicaOdontologica.exception.ResourceNotFoundException;
import com.backend.clinicaOdontologica.model.Domicilio;
import com.backend.clinicaOdontologica.model.Odontologo;
import com.backend.clinicaOdontologica.model.Paciente;
import com.backend.clinicaOdontologica.repository.OdontologoRepository;
import com.backend.clinicaOdontologica.service.IOdontologoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {
    private final Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);

    private OdontologoRepository odontologoRepository;
    private ModelMapper modelMapper;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository, ModelMapper modelMapper) {
        this.odontologoRepository = odontologoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OdontologoSalidaDto> listarOdontologos() {
        List<OdontologoSalidaDto> odontologoSalidaDto = odontologoRepository.findAll()
                .stream()
                .map(odontologo -> modelMapper.map(odontologo, OdontologoSalidaDto.class))
                .toList();

        if (LOGGER.isInfoEnabled())
            LOGGER.info("Listado de todos los odontologos: {}", odontologoSalidaDto);

        return odontologoSalidaDto;
    }

    public OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo) {

        LOGGER.info("OdontologoEntradaDTO: " + odontologo.toString());

        Odontologo odontologoEntidad = mapDTOAEntidad(odontologo);

        //GUARDAMOS ODONTOLOGO
        Odontologo odontologoAPersistir = odontologoRepository.save(odontologoEntidad);


        OdontologoSalidaDto odontologoSalidaDto = modelMapper.map(odontologoAPersistir, OdontologoSalidaDto.class);

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
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        if(odontologoRepository.existsById(id)) {
            LOGGER.warn("Se ha eliminado el odontologo con id: {}", id);
            odontologoRepository.deleteById(id);
        }
        else{
            LOGGER.error("Error al eliminar odontologo, no existe. id: {}" ,id);
            throw new ResourceNotFoundException("Error al eliminar odontologo, no existe. ID: " + id);
        }
        odontologoRepository.deleteById(id);
    }

    @Override
    public OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionDto odontologoModificacionDto) throws ResourceNotFoundException {
        Odontologo odontologoRecibido = modelMapper.map(odontologoModificacionDto, Odontologo.class);
        Odontologo odontologoActualizar = odontologoRepository.findById(odontologoModificacionDto.getId()).orElse(null);
        OdontologoSalidaDto odontologoSalida = null;
        if (odontologoActualizar != null) {

            //declaramos odontologo encontrado con los datos del recibido y guardamos nuevamente
            odontologoActualizar = odontologoRecibido;
            odontologoRepository.save(odontologoActualizar);

            odontologoSalida = modelMapper.map(odontologoActualizar, OdontologoSalidaDto.class);

            LOGGER.warn("Odontologo actualizado: {}", odontologoSalida);
        }
        else{
            LOGGER.error("Error al actualizar odontologo, no se enontro registrado");
            throw new ResourceNotFoundException("Error al actualizar odontologo, no se enontro registrado");
        }
        return odontologoSalida;
    }

    private Odontologo mapDTOAEntidad(OdontologoEntradaDto odontologoEntradaDto) {
        return modelMapper.map(odontologoEntradaDto, Odontologo.class);
    }


}
