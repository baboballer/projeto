package org.iftm.projeto9033.services;

import org.iftm.projeto9033.entities.Aluno;
import org.iftm.projeto9033.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repositorio;

	public Aluno insert(Aluno aluno) {
		if (aluno.getCpf() == null || aluno.getCpf().isEmpty()) {
			throw new IllegalArgumentException("O CPF é obrigatório.");
		}
		if (aluno.getEmail() == null || aluno.getEmail().isEmpty()) {
			throw new IllegalArgumentException("O e-mail é obrigatório.");
		}
		return repositorio.save(aluno);
	}
}