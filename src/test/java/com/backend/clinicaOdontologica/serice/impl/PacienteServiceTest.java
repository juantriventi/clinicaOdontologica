package com.backend.clinicaOdontologica.serice.impl;

import com.backend.clinicaOdontologica.dto.entrada.DomicilioEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.PacienteEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.PacienteSalidaDto;
import com.backend.clinicaOdontologica.exception.ResourceNotFoundException;
import com.backend.clinicaOdontologica.service.impl.PacienteService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;


    @Test
    @Order(1)
    void deberiaRegistrarUnPacienteJereYDevolverSuId(){
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("jere", "GG", 42152955, LocalDate.of(2023, 12, 2), new DomicilioEntradaDto("calle", 3456, "Palermo", "CABA"));

        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);

        assertNotNull(pacienteSalidaDto.getId());
        assertEquals("jere", pacienteSalidaDto.getNombre());
    }


    @Test
    @Order(2)
    void alIntentarEliminarUnPacienteConId1EliminadoDeberiaDevolverExcepcion(){

        try{
            pacienteService.eliminarPaciente(1L);
        } catch (Exception exception){
            exception.printStackTrace();
        }

        assertThrows(ResourceNotFoundException.class, () -> pacienteService.eliminarPaciente(1L));
    }

    @Test
    @Order(3)
    void deberiaDevolverUnaListaDePacientesVaica(){

        List<PacienteSalidaDto> pacientesDto = pacienteService.listarPacientes();

        assertTrue(pacientesDto.isEmpty());

    }


}
