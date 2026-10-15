package repository;

public class AlunoRepository package br.com.api.alunos.repository;

import br.com.api.alunos.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository
        extends JpaRepository<Aluno, Long> {
}{
}
