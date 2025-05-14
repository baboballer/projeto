package org.iftm.projeto9033.repositories;

import org.iftm.projeto9033.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}