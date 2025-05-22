package factory.framework;

public abstract class Factory {
  public final Product create(String owner) {
    Product p = createProduct(owner);
    registerProduct(p); // 카드를 만들고 나서 등록을 해야 사용할 수 있다.
    return p;
  }

  // 추상 메서드
  protected abstract Product createProduct(String owner);
  protected abstract void registerProduct(Product product);

}
