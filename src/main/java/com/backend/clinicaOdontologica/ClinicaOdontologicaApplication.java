package com.backend.clinicaOdontologica;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		System.out.println("Aplicacion corriendo en el puerto 8080");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


}
