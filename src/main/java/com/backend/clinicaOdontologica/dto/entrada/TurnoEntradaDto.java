package com.backend.clinicaOdontologica.dto.entrada;

import com.backend.clinicaOdontologica.model.Odontologo;
import com.backend.clinicaOdontologica.model.Paciente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class TurnoEntradaDto {
    @NotNull(message="La fecha no puede ser nula")
    @NotBlank(message="Debe especificarse la fecha")
    private LocalDateTime fechaYhora;

    @NotNull(message="El odontologo no puede ser nulo")
    @NotBlank(message="Debe especificarse el odontologo")
    private Odontologo odontologo;

    @NotNull(message="El paciente no puede ser nulo")
    @NotBlank(message="Debe especificarse el paciente")
    private Paciente paciente;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(LocalDateTime fechaYhora, Odontologo odontologo, Paciente paciente) {

        this.fechaYhora = fechaYhora;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public LocalDateTime getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
