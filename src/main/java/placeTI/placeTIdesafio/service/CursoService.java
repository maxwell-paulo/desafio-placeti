package placeTI.placeTIdesafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import placeTI.placeTIdesafio.entity.Curso;
import placeTI.placeTIdesafio.entity.Turma;
import placeTI.placeTIdesafio.repository.CursoRepository;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TurmaService turmaService; // Injete o serviço de Turma

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @PostMapping("/")
    public Curso createCurso(@RequestBody Curso novoCurso2) {
    Curso novoCurso = new Curso();
    novoCurso.setNome(novoCurso2);
    return createCurso(novoCurso);
}
    

    public Curso buscarCursoPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public void deletarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    public Curso criarEAssociarTurma(Long cursoId, String codigoTurma, String nomeTurma) {
        Curso curso = buscarCursoPorId(cursoId);
        if (curso != null) {
            Turma turma = new Turma();
            turma.setCodigo(codigoTurma);
            turma.setNome(nomeTurma);

            turma.setCurso(curso);

            turma = turmaService.criarTurma(turma);

            List<Turma> turmas = curso.getTurmas();
            turmas.add(turma);
            curso.setTurmas(turmas);

            return cursoRepository.save(curso);
        }
        return null;
    }

}

