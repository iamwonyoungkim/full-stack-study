package iterator;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> { // Advanced for를 사용하기 위해서는 Iterable의 구현 클래스여야 한다.
  private Book[] books;
  private int last = 0;

  public BookShelf(int maxsize) {
    this.books = new Book[maxsize];
  }

  public Book getBookAt(int index) {
    return books[index];
  }

  public void appendBook(Book book) {
    books[last++] = book;
  }

  public int getLength() {
    return last;
  }

  @Override
  public Iterator<Book> iterator() {
    return new BookShelfIterator(this);
  }
}
