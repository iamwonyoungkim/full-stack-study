package practical.apr22;

public class Test {

  public static void main(String[] args) {
    Button okButton = new Button();
    Button cancelButton = new Button();

    okButton.setClickListener(new OkButtonListener());
    okButton.click();

    cancelButton.setClickListener(new CancelButtonListener());
    cancelButton.click();
  }

}
