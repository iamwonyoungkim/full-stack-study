package practical.apr29.generic01;

public class Test {

  public static void main(String[] args) {
    Box<A> ABox = new Box<>();
    ABox.set(new A());
    ABox.get();
  }

}
