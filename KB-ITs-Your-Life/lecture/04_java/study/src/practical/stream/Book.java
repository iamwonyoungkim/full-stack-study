package practical.stream;

import lombok.Data;

@Data
public class Book implements Comparable<Book> {

  @Override
  public int compareTo(Book o) {
    return title.compareTo(o.getTitle());
  }

  private String title;
  private int price;
  private String publisher;
  private boolean isEbook;

  public Book(String title, int price, String publisher, boolean isEbook) {
    this.title = title;
    this.price = price;
    this.publisher = publisher;
    this.isEbook = isEbook;
  }
}
