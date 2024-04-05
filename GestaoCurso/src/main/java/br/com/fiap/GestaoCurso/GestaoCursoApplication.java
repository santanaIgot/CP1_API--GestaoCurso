package br.com.fiap.GestaoCurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestaoCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoCursoApplication.class, args);
	}
}
