package br.edu.luizfernando.gestao_cursos.Exceptions;

public class MessageDeleteException extends RuntimeException{
  public MessageDeleteException() {
    super("Curso não existe!");
  }
}
