package practical.Apr22;

public interface ClickListener {
  void onClick();

}

class OkButtonListener implements ClickListener {
  public void onClick() {
    System.out.println("OK button clicked");
  }
}

class CancelButtonListener implements ClickListener {
  public void onClick() {
    System.out.println("Cancel button clicked");
  }
}
