package br.edu.luizfernando.gestao_cursos.modules.curso.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.luizfernando.gestao_cursos.Exceptions.MessageDeleteException;
import br.edu.luizfernando.gestao_cursos.modules.curso.CursoEntity;
import br.edu.luizfernando.gestao_cursos.modules.curso.CursoRepository;

@Service
public class RemoveCursoUseCases {

  @Autowired
  private CursoRepository cursoRepository;

  public void execute(CursoEntity cursoEntity) {
    if (cursoRepository.findById(cursoEntity.getId()).isEmpty()) {
      throw new MessageDeleteException();
    }
    this.cursoRepository.delete(cursoEntity);
  }

}
