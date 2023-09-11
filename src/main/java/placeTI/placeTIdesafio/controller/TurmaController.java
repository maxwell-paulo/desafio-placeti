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

import placeTI.placeTIdesafio.entity.Turma;
import placeTI.placeTIdesafio.repository.TurmaRepository;
import placeTI.placeTIdesafio.service.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping("/")
    public List<Turma> getAllTurmas() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Turma getTurmaById(@PathVariable Long id) {
        return turmaRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Turma createTurma(@RequestBody Turma turma) {
        return turmaService.criarTurma(turma);
    }

    @PutMapping("/{id}")
    public Turma updateTurma(@PathVariable Long id, @RequestBody Turma novaTurma) {
        return turmaRepository.findById(id)
            .map(turma -> {
                turma.setCodigo(novaTurma.getCodigo());
                turma.setNome(novaTurma.getNome());
                turma.setCurso(novaTurma.getCurso());
                return turmaRepository.save(turma);
            })
            .orElseGet(() -> {
                novaTurma.setId(id);
                return turmaRepository.save(novaTurma);
            });
    }

    @DeleteMapping("/{id}")
    public void deleteTurma(@PathVariable Long id) {
        turmaRepository.deleteById(id);
    }
}
