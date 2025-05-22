package practical.interfaceEx;

public class Test {

  public static void main(String[] args) {
    // Interface는 new 할 수 없다. (즉, 객체를 생성할 수 없다)
    // new Device();
    // new InputDevice();
    // new OutputDevice();

    // 인터페이스도 객체 생성 시 부모 타입으로 사용은 가능하다.
    InputDevice mouse = new Mouse();
    mouse.on();
    mouse.off();
    mouse.getData();

    Device keyboard = new Keyboard();
    keyboard.on();
    keyboard.off();
    // keyboard.getData() // 얘는 InputDevice Interface의 메소드는 호출할 수 없다.

    OutputDevice monitor = new Monitor();
    monitor.on();
    monitor.off();
    monitor.sendData("테스트 데이터");

    Device printer = new Printer();
    printer.on();
    printer.off();
    // printer.sendData("테스트 데이터"); // 얘는 OutputDevice Interface의 메소드를 호출할 수 없다.

    // 다형성에 이용할 수 있다.
    // 변수 타입으로, 매개변수 타입으로 사용할 수 있다.

    // 정적 메소드 호출
    System.out.println(Device.checkDeviceType(keyboard));
    System.out.println(Device.checkDeviceType(mouse));
    System.out.println(Device.checkDeviceType(printer));
    System.out.println(Device.checkDeviceType(monitor));
    System.out.println(Device.checkDeviceType(null));

    keyboard.reset();
    printer.reset();
  }

}
