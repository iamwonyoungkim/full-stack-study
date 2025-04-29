package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> {

  private BookShelf bookShelf;
  private int index;

  public BookShelfIterator(BookShelf bookShelf) {
    this.bookShelf = bookShelf;
    this.index = 0;
  }

  @Override
  public boolean hasNext() {
    if(index < bookShelf.getLength()) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Book next() {
    if(!hasNext()) {
      throw new NoSuchElementException(); // RuntimeException이므로 throws를 안해줘도 된다.
    }

    Book book = bookShelf.getBookAt(index);
    index++;
    return book;
  }
}
