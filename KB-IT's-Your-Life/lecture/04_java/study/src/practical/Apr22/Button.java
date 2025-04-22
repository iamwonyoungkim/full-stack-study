package practical.Apr22;

public class Button {
  private ClickListener clickListener;

  public void setClickListener(ClickListener clickListener) {
    this.clickListener = clickListener;
  }

  public void click() {
    this.clickListener.onClick();
  }

}
