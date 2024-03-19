package br.edu.luizfernando.gestao_cursos.Exceptions;

public class UserFoundException extends RuntimeException {
  public UserFoundException() {
    super("Curso já existe!");
  }
}
