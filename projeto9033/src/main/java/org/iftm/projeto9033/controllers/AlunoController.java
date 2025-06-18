package org.iftm.projeto9033.controllers;

import org.iftm.projeto9033.entities.Aluno;
import org.iftm.projeto9033.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // Endpoint: Listar todos os alunos
    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> lista = alunoService.findAll();
        return ResponseEntity.ok(lista);
    }

    // Endpoint: Buscar aluno por ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        return alunoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint: Inserir novo aluno
    @PostMapping
    public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.insert(aluno);
        return ResponseEntity.ok(novoAluno);
    }

    // Endpoint: Atualizar aluno por ID
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        try {
            Aluno aluno = alunoService.update(id, alunoAtualizado);
            return ResponseEntity.ok(aluno);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint: Deletar aluno por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}