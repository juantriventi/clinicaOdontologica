package com.backend.clinicaOdontologica.serice.impl;


import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.exception.ResourceNotFoundException;
import com.backend.clinicaOdontologica.service.impl.OdontologoService;
import com.backend.clinicaOdontologica.service.impl.PacienteService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OdontologoServiceTest {


    @Autowired
    private OdontologoService odontologoService;


    @Test
    @Order(1)
    void deberiaRegistrarUnOdontologoJuanYDevolverSuId(){
        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("1234567890","juan","tri");

        OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);

        assertNotNull(odontologoSalidaDto.getId());
        assertEquals("juan", odontologoSalidaDto.getNombre());
    }


    @Test
    @Order(2)
    void alIntentarEliminarUnOdontologoConId1EliminadoDeberiaDevolverExcepcion(){

        try{
            odontologoService.eliminarOdontologo(1L);
        } catch (Exception exception){
            exception.printStackTrace();
        }

        assertThrows(ResourceNotFoundException.class, () -> odontologoService.eliminarOdontologo(1L));
    }

    @Test
    @Order(3)
    void deberiaDevolverUnaListaDeodontologosVaica(){

        List<OdontologoSalidaDto> odontologoSalidaDtoList = odontologoService.listarOdontologos();

        assertTrue(odontologoSalidaDtoList.isEmpty());

    }


}
