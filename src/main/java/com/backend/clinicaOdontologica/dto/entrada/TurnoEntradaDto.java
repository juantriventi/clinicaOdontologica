package com.backend.clinicaOdontologica.dto.entrada;

import com.backend.clinicaOdontologica.model.Odontologo;
import com.backend.clinicaOdontologica.model.Paciente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class TurnoEntradaDto {
    @NotNull(message = "El id del odontólogo no puede ser nulo")
    private Long odontologoId;

    @NotNull(message = "El id del paciente no puede ser nulo")
    private Long pacienteId;

    @NotNull(message = "La fecha y hora no pueden ser nulas")
    private LocalDateTime fechaYHora;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(@NotNull(message = "El id del odontólogo no puede ser nulo") Long odontologoId, @NotNull(message = "El id del paciente no puede ser nulo") Long pacienteId, @NotNull(message = "La fecha y hora no pueden ser nulas") LocalDateTime fechaYHora) {
        this.odontologoId = odontologoId;
        this.pacienteId = pacienteId;
        this.fechaYHora = fechaYHora;
    }

    public Long getOdontologoId() {
        return odontologoId;
    }

    public void setOdontologoId(Long odontologoId) {
        this.odontologoId = odontologoId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public Throwable getFechaYHora() {
        return null;
    }
}
