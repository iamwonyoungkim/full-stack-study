package practical.interfaceEx;

public interface OutputDevice extends Device {
  String TYPE = PREFIX + "OUTPUT";

  void sendData(String data);
}
