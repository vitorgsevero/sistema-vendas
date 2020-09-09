package com.vitorgsevero.io.sistemavendas;

import com.vitorgsevero.io.sistemavendas.auditing.AuditorAwareImpl;
import com.vitorgsevero.io.sistemavendas.csv.LeitorCSV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.IOException;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ApiApplication {

	@Bean
	public AuditorAware<String> auditorAware(){
		return new AuditorAwareImpl();
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		SpringApplication.run(ApiApplication.class, args);

		LeitorCSV leitorCSV = new LeitorCSV();
		leitorCSV.readCSV();

	}

}
