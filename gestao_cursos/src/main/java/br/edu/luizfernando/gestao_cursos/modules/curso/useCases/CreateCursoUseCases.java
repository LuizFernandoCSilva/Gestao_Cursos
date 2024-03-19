package br.edu.luizfernando.gestao_cursos.modules.curso.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.luizfernando.gestao_cursos.Exceptions.UserFoundException;
import br.edu.luizfernando.gestao_cursos.modules.curso.CursoEntity;
import br.edu.luizfernando.gestao_cursos.modules.curso.CursoRepository;

@Service
public class CreateCursoUseCases {
  
  @Autowired
  private CursoRepository cursoRepository;

  public CursoEntity execute(CursoEntity cursoEntity){
    this.cursoRepository.findById(cursoEntity.getId()).ifPresent((user) -> {
      throw new UserFoundException();
    });
    return this.cursoRepository.save(cursoEntity);
  }
}
