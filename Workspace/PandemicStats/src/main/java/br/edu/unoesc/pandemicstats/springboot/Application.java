package br.edu.unoesc.pandemicstats.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


/**
 * Spring Boot application starter class
 * @author Spring Boot
 * @author Eduardo Mateus da Costa
 * @since 30/10/2021
 * @version 1.0
 */
@EntityScan(basePackages = "br.edu.unoesc.pandemicstats.springboot.model")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

