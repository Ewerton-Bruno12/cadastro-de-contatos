package br.com.ewerton.cadastro_de_contatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CadastroDeContatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeContatosApplication.class, args);
	}

}
