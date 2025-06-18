package org.iftm.projeto9033.services;

import org.iftm.projeto9033.entities.Aluno;
import org.iftm.projeto9033.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // Regra: Listar todos os alunos
    @Transactional(readOnly = true)
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    // Regra: Buscar aluno por ID
    @Transactional(readOnly = true)
    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    // Regra: Inserir aluno com validações
    @Transactional
    public Aluno insert(Aluno aluno) {
        validateNome(aluno.getNome());
        validateCpf(aluno.getCpf());
        validateTelefone(aluno.getTelefone());
        validateEmail(aluno.getEmail());
        validateMatricula(aluno.getMatricula());
        validateEndereco(aluno.getEndereco());
        return alunoRepository.save(aluno);
    }

    // Regra: Atualizar aluno com validações
    @Transactional
    public Aluno update(Long id, Aluno updatedAluno) {
        Aluno entity = alunoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        validateNome(updatedAluno.getNome());
        validateCpf(updatedAluno.getCpf());
        validateTelefone(updatedAluno.getTelefone());
        validateEmail(updatedAluno.getEmail());
        validateMatricula(updatedAluno.getMatricula());
        validateEndereco(updatedAluno.getEndereco());

        entity.setNome(updatedAluno.getNome());
        entity.setCpf(updatedAluno.getCpf());
        entity.setTelefone(updatedAluno.getTelefone());
        entity.setEmail(updatedAluno.getEmail());
        entity.setMatricula(updatedAluno.getMatricula());
        entity.setEndereco(updatedAluno.getEndereco());

        return alunoRepository.save(entity);
    }

    // Regra: Deletar aluno
    @Transactional
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }

    // Regras de validação

    private void validateNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório.");
        }
    }

    private void validateCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("O CPF é obrigatório.");
        }
    }

    private void validateTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("O telefone é obrigatório.");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("O e-mail é obrigatório.");
        }
    }

    private void validateMatricula(String matricula) {
        if (matricula == null || matricula.trim().isEmpty()) {
            throw new IllegalArgumentException("A matrícula é obrigatória.");
        }
    }

    private void validateEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("O endereço é obrigatório.");
        }
    }
}