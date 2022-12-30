package com.emse.spring.faircorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main application class for the Faircorp project.
 * <p>
 * This class is used to launch the Spring Boot application and configure
 * the necessary components for the project. It is annotated with the
 * `@SpringBootApplication` annotation, which enables several key features
 * of the Spring Boot framework, including component scanning, autoconfiguration,
 * and property support.
 * <p>
 * To run the application, simply execute the `main` method in this class.
 */
@SpringBootApplication
public class FaircorpApplication {





	/**
	 * The main entry point for the application.
	 *
	 * @param args command-line arguments passed to the application.
	 * <p>
	 * This method is responsible for launching the Spring Boot application.
	 * It uses the `SpringApplication.run` method to bootstrap the application
	 * and configure all the necessary components.
	 */
	public static void main(String[] args) {


		SpringApplication.run(FaircorpApplication.class,args);
	}

}
