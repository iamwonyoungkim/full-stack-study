package practical.set;

import java.util.Objects;

public class HashTest {

  public static void main(String[] args) {
    // Objects.hash()
    System.out.println(Objects.hash("A"));
    System.out.println(Objects.hash("A"));
    System.out.println(Objects.hash("B"));
  }

}
