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
        if (turma.getCodigo() == null || turma.getCodigo().isEmpty()) {
            throw new IllegalArgumentException("O código da turma não pode estar vazio.");
        }


        return turmaRepository.save(turma);
    }

}
