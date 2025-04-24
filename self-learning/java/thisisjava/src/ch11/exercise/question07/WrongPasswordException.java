package ch11.exercise.question07;

public class WrongPasswordException extends Exception {

  public WrongPasswordException() {
  }

  public WrongPasswordException(String message) {
    super(message);
  }
}
