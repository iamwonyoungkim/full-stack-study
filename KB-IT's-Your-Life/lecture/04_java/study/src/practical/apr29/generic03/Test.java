package practical.apr29.generic03;

public class Test {

  public static void main(String[] args) {
    Store.Service.deliver(new Store<HeavyItem>());
    Store.Service.deliver(new Store<>());

    Store.Service.deliver(new Store<TV>());

    Store.Service.pack(new Store<LightItem>());
    Store.Service.pack(new Store<>());
  }

}
