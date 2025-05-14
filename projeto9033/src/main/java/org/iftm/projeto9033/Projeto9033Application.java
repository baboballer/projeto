package org.iftm.projeto9033;

import java.time.Instant;

import org.iftm.projeto9033.entities.Aluno;
import org.iftm.projeto9033.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Projeto9033Application implements CommandLineRunner {

	@Autowired
	private AlunoService servicos;

	public static void main(String[] args) {
		SpringApplication.run(Projeto9033Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNome("João da Silva");
		aluno.setCpf("12345678900");
		aluno.setTelefone("99999-1234");
		aluno.setEmail("joao.silva@example.com");
		aluno.setMatricula("20250001");
		aluno.setEndereco("Rua das Flores, 100");

		try {
			servicos.insert(aluno);
		} catch (IllegalArgumentException e) {
			System.out.println("\nErro: " + e.getMessage() + "\n");
		}
	}
}