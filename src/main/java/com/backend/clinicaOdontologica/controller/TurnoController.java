package com.backend.clinicaOdontologica.controller;

import com.backend.clinicaOdontologica.dto.entrada.TurnoEntradaDto;
import com.backend.clinicaOdontologica.dto.salida.TurnoSalidaDto;
import com.backend.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {

    private final ITurnoService turnoService;

    @Autowired
    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping("/programar")
    public ResponseEntity<TurnoSalidaDto> programarTurno(@RequestBody TurnoEntradaDto turnoEntradaDto) {
        // Lógica para programar un turno
        TurnoSalidaDto turnoProgramado = turnoService.programarTurno(turnoEntradaDto);

        // Devolver respuesta exitosa con el turno programado
        return ResponseEntity.ok(turnoProgramado);
    }

    @GetMapping("/listar")
    public List<TurnoSalidaDto> listarTurnos() {
        return turnoService.listarTurnos();
    }

    @DeleteMapping("/cancelar/{turnoId}")
    public void cancelarTurno(@PathVariable Long turnoId) {
        turnoService.cancelarTurno(turnoId);
    }

}
