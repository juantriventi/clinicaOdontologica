package com.backend.clinicaOdontologica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class ClinicaOdontologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		crearTabla();
	}

	private static void crearTabla(){
		Connection connection = null;
		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");

		} catch (Exception e){
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
