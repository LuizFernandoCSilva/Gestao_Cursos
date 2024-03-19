package br.edu.luizfernando.gestao_cursos.modules.curso.useCases;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.luizfernando.gestao_cursos.Exceptions.UpdateFailed;
import br.edu.luizfernando.gestao_cursos.modules.curso.CursoEntity;
import br.edu.luizfernando.gestao_cursos.modules.curso.CursoRepository;

@Service
public class UpdateCursoUsecases {

  @Autowired
  private CursoRepository cursoRepository;

  public CursoEntity update(CursoEntity cursoEntity) {
    if (cursoRepository.findById(cursoEntity.getId()).isPresent()) {
      CursoEntity existingCurso = cursoRepository.findById(cursoEntity.getId()).get();
      existingCurso.setName(cursoEntity.getName());
      existingCurso.setCategory(cursoEntity.getCategory());
      return cursoRepository.save(existingCurso);
    } else {
      throw new UpdateFailed();
    }
  }

  public CursoEntity toggleCursoActive(CursoEntity cursoEntity) {
    if (cursoRepository.findById(cursoEntity.getId()).isPresent()) {
      CursoEntity existingCurso = cursoRepository.findById(cursoEntity.getId()).get();
      existingCurso.setActive(!existingCurso.getActive());
      return cursoRepository.save(existingCurso);
    } else {
      throw new UpdateFailed();
    }
  }
}
