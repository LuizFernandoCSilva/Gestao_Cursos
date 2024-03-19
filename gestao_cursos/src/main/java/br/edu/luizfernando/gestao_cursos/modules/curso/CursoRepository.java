package br.edu.luizfernando.gestao_cursos.modules.curso;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<CursoEntity, UUID>{
  Optional<CursoEntity> findById(UUID id);
}
