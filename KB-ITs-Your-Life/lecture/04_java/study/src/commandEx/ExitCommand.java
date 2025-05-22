package commandEx;

import java.util.Scanner;

public class ExitCommand implements Command {

  @Override
  public void execute() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("종료할까요?(Y/N) ");
    String answer = scanner.nextLine();

    scanner.close();
    if(answer.isEmpty() || answer.equalsIgnoreCase("Y")) {
      System.exit(0);
    }
  }
}
