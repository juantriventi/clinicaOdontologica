package com.backend.clinicaOdontologica.controller;

import com.backend.clinicaOdontologica.dto.entrada.OdontologoEntradaDto;
import com.backend.clinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.OdontologoSalidaDto;
import com.backend.clinicaOdontologica.dto.salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.exception.ResourceNotFoundException;
import com.backend.clinicaOdontologica.service.IOdontologoService;
import com.backend.clinicaOdontologica.service.ITurnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    private final ITurnoService turnoService;
    @Autowired
    public TurnoController(ITurnoService turnoService, IOdontologoService odontologoService) {
        this.turnoService = turnoService;
    }
    @PostMapping("/registrar")
    public ResponseEntity<TurnoSalidaDto> registrarTurno(@RequestBody TurnoEntradaDto turnoEntradaDto) {
        TurnoSalidaDto turnoRegistrado = turnoService.registrarTurno(turnoEntradaDto);
        return ResponseEntity.ok(turnoRegistrado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TurnoSalidaDto>> listarTodosLosTurnos() {
        List<TurnoSalidaDto> turnos = turnoService.listarTodosLosTurnos();
        return ResponseEntity.ok(turnos);
    }


    @GetMapping("{id}")
    public ResponseEntity<TurnoSalidaDto> obtenerTurnoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        TurnoSalidaDto turno = turnoService.buscarTurnoPorId(id);
        return ResponseEntity.ok(turno);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarTurnoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurnoPorId(id);
        return ResponseEntity.ok("Turno eliminado correctamente");
    }
}