package placeTI.placeTIdesafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import placeTI.placeTIdesafio.entity.Curso;
import placeTI.placeTIdesafio.repository.CursoRepository;
import placeTI.placeTIdesafio.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/")
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Curso getCursoById(@PathVariable Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.createCurso(curso);
    }

    @PutMapping("/{id}")
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso novoCurso) {
        return cursoRepository.findById(id)
            .map(curso -> {
                curso.setNome(novoCurso.getNome());
                curso.setQuantidadeAlunos(novoCurso.getQuantidadeAlunos());
                curso.setNivelCurso(novoCurso.getNivelCurso());
                return cursoRepository.save(curso);
            })
            .orElseGet(() -> {
                novoCurso.setId(id);
                return cursoRepository.save(novoCurso);
            });
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoRepository.deleteById(id);
    }
}
