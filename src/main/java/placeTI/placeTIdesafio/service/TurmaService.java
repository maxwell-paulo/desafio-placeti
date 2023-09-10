package placeTI.placeTIdesafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import placeTI.placeTIdesafio.entity.Turma;
import placeTI.placeTIdesafio.repository.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma criarTurma(Turma turma) {
        // Aqui você pode adicionar validações antes de salvar a turma
        if (turma.getCodigo() == null || turma.getCodigo().isEmpty()) {
            throw new IllegalArgumentException("O código da turma não pode estar vazio.");
        }

        // Aqui você pode adicionar lógica adicional, se necessário
        // Por exemplo, atribuir uma data de início padrão à turma

        return turmaRepository.save(turma);
    }

    // Outros métodos relacionados a turmas, se necessário
}
