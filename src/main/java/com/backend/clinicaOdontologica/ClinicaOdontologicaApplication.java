package com.backend.clinicaOdontologica;

import org.springframework.boot.CommandLineRunner;
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
	public CommandLineRunner run(JdbcTemplate jdbcTemplate) {
		return args -> {
			try {
				jdbcTemplate.execute("DROP TABLE IF EXISTS DOMICILIOS");
				jdbcTemplate.execute("CREATE TABLE DOMICILIOS (ID INT AUTO_INCREMENT PRIMARY KEY, CALLE VARCHAR(50) NOT NULL, NUMERO INT NOT NULL, LOCALIDAD VARCHAR(50) NOT NULL, PROVINCIA VARCHAR(50) NOT NULL)");

				jdbcTemplate.execute("DROP TABLE IF EXISTS PACIENTES");
				jdbcTemplate.execute("CREATE TABLE PACIENTES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, DNI INT NOT NULL, FECHA DATE NOT NULL, DOMICILIO_ID INT)");

				jdbcTemplate.execute("DROP TABLE IF EXISTS ODONTOLOGOS");
				jdbcTemplate.execute("CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY, MATRICULA VARCHAR(100) NOT NULL, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL)");
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}
}
