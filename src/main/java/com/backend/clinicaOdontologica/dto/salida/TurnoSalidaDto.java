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
    private OdontologoSalidaDto odontologo;

    @NotNull(message="El paciente no puede ser nulo")
    @NotBlank(message="Debe especificarse el paciente")
    private PacienteSalidaDto paciente;

    public TurnoSalidaDto() {
    }

    public TurnoSalidaDto(long id, @NotNull(message = "La fecha no puede ser nula") LocalDateTime fechaYhora, @NotNull(message = "El odontologo no puede ser nulo") OdontologoSalidaDto odontologo, @NotNull(message = "El paciente no puede ser nulo") PacienteSalidaDto paciente) {
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


    public OdontologoSalidaDto getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(OdontologoSalidaDto odontologo) {
        this.odontologo = odontologo;
    }

    public PacienteSalidaDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteSalidaDto paciente) {
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYhora = fechaYHora;
    }
}
