package com.backend.clinicaOdontologica.dto.entrada;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Digits;
public class DomicilioEntradaDto {



    @NotNull(message = "El campo calle no puede ser nulo")
    @NotBlank(message = "El campo calle no puede estar en blanco")
    private String calle;

    @NotNull(message = "El campo numero no puede ser nulo")
    @Digits(integer = 8, fraction = 0, message = "El número debe tener como máximo 8 dígitos")
    //@Pattern(regexp = "\\d{1,8}", message = "El número debe tener como máximo 8 dígitos")
    private Integer numero;

    @NotNull(message = "El campo localidad no puede ser nulo")
    @NotBlank(message = "El campo localidad no puede estar en blanco")
    private String localidad;

    @NotNull(message = "El campo provincia no puede ser nulo")
    @NotBlank(message = "El campo provincia no puede estar en blanco")
    private String provincia;

    public DomicilioEntradaDto() {
    }

    public DomicilioEntradaDto(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "DomicilioEntradaDto{" +
                "calle='" + calle + '\'' +
                ", numero=" + numero +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }

}
