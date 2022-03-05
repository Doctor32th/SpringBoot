package com.biblioteca.biblioSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Doctor32
 * Principal. Hemos añadido la anotación EntityScan
 * para que Spring pueda escanear lo que hay aquí dentro.
 */

@SpringBootApplication
@EntityScan(basePackages="models")
public class BiblioSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiblioSpringApplication.class, args);
	}

}
