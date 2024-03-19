package br.edu.luizfernando.gestao_cursos.modules.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.luizfernando.gestao_cursos.modules.curso.CursoEntity;
import br.edu.luizfernando.gestao_cursos.modules.curso.CursoListRepository;
import br.edu.luizfernando.gestao_cursos.modules.curso.useCases.CreateCursoUseCases;
import br.edu.luizfernando.gestao_cursos.modules.curso.useCases.RemoveCursoUseCases;
import br.edu.luizfernando.gestao_cursos.modules.curso.useCases.UpdateCursoUsecases;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {

  @Autowired
  private CreateCursoUseCases createCandidateUseCases;

  @Autowired
  private RemoveCursoUseCases removeCursoUseCases;

  @Autowired
  private UpdateCursoUsecases updateCursoUseCases;

  @Autowired
  private CursoListRepository cursoListRepository;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CursoEntity cursoEntity) {
    try {
      var result = this.createCandidateUseCases.execute(cursoEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> remove(@Valid @RequestBody CursoEntity cursoEntity) {
    try {
      this.removeCursoUseCases.execute(cursoEntity);
      return ResponseEntity.ok().body("Curso removido com sucesso");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@RequestBody CursoEntity cursoEntity) {
    try {
      var result = this.updateCursoUseCases.update(cursoEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PatchMapping("/{id}/active")
  public ResponseEntity<Object> toggleCursoActive(@RequestBody CursoEntity cursoEntity) {
    try {
      var result = this.updateCursoUseCases.toggleCursoActive(cursoEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/")
  public ResponseEntity<List<CursoEntity>> getAllCursos() {
    List<CursoEntity> cursos = cursoListRepository.findAll();
    return ResponseEntity.ok().body(cursos);
  }
}
