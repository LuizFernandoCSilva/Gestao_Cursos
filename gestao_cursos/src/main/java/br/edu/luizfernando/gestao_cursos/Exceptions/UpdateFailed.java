package br.edu.luizfernando.gestao_cursos.Exceptions;

public class UpdateFailed extends RuntimeException {
  public UpdateFailed() {
    super("Impossível atualizar, curso não existente !");
  }
}
