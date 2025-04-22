package practical.interfaceEx;

public interface InputDevice extends Device {
  String TYPE = PREFIX + "INPUT";

  void getData();
}
