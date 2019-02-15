package fr.doranco.boot_fiche_urgence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class BootFicheUrgenceApplication {

    public static void main(String[] args) {

        SpringApplication.run(BootFicheUrgenceApplication.class, args);
    }

}

