package br.com.api.alunos.service;

import br.com.api.alunos.dto.AlunoRequest;
import br.com.api.alunos.entity.Aluno;
import br.com.api.alunos.repository.AlunoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void update(Long id, AlunoRequest request) {

        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado: " + id));

        aluno.setNome(request.getNome());
        aluno.setRa(request.getRa());

        alunoRepository.save(aluno);
    }

    public void deleteById(Long id) {

        boolean exists = alunoRepository.existsById(id);

        if (!exists) {
            throw new RuntimeException("Aluno não encontrado: " + id);
        }

        alunoRepository.deleteById(id);
    }
}
