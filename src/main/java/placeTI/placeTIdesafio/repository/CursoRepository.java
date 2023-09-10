package placeTI.placeTIdesafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import placeTI.placeTIdesafio.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}

