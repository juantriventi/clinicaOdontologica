package com.backend.clinicaOdontologica.dto.salida;

import com.backend.clinicaOdontologica.model.Odontologo;
import com.backend.clinicaOdontologica.model.Paciente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class TurnoSalidaDto {
    private long id;
    @NotNull(message="La fecha no puede ser nula")
    @NotBlank(message="Debe especificarse la fecha")
    private LocalDateTime fechaYhora;

    @NotNull(message="El odontologo no puede ser nulo")
    @NotBlank(message="Debe especificarse el odontologo")
    private Odontologo odontologo;

    @NotNull(message="El paciente no puede ser nulo")
    @NotBlank(message="Debe especificarse el paciente")
    private Paciente paciente;

    public TurnoSalidaDto() {
    }

    public TurnoSalidaDto(LocalDateTime fechaYhora, Odontologo odontologo, Paciente paciente) {
        this.id = id;
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
