package practical.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
  static List<Book> books = new ArrayList<>(
      Arrays.asList(
          new Book("Java", 1500, "momo", true),
          new Book("Xml", 2500, "mc", true),
          new Book("Java5", 3000, "mc", false),
          new Book("Html", 2800, "momo", true),
          new Book("Web", 5500, "mc", false),
          new Book("Web", 5500, "mc", false)
      )
  );

}
