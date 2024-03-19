package br.edu.luizfernando.gestao_cursos.modules.curso;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoListRepository extends JpaRepository<CursoEntity, UUID> {
}
