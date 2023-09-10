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
    return createCurso(novoCurso); // Use criarCurso() em vez de cursoService.criarCurso()
}
    

    public Curso buscarCursoPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public void deletarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    // Método para criar e associar turmas a um curso
    public Curso criarEAssociarTurma(Long cursoId, String codigoTurma, String nomeTurma) {
        Curso curso = buscarCursoPorId(cursoId);
        if (curso != null) {
            // Cria uma nova instância de turma
            Turma turma = new Turma();
            turma.setCodigo(codigoTurma);
            turma.setNome(nomeTurma);

            // Associa a turma ao curso
            turma.setCurso(curso);

            // Salva a turma no repositório de turmas
            turma = turmaService.criarTurma(turma);

            // Atualiza a lista de turmas no curso
            List<Turma> turmas = curso.getTurmas();
            turmas.add(turma);
            curso.setTurmas(turmas);

            // Salva o curso atualizado no repositório de cursos
            return cursoRepository.save(curso);
        }
        return null; // Curso não encontrado
    }

    // Outros métodos e lógica relacionados aos cursos

}

