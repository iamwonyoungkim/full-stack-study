package practical.apr29.generic03;

public class Store<T> {

  static class Service {

    // 배달은 무거운 아이템만
    static void deliver(Store<? extends HeavyItem> store) {
      System.out.println("배달을 신속히 한다.");
    }

    // 포장은 가벼운 아이템만
    static void pack(Store<? extends LightItem> store) {
      System.out.println("포장을 예쁘게 한다.");
    }
  }

}
