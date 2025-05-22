package practical.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// 스트림 기본
public class Test01 {

  public static void main(String[] args) {
    System.out.println("---------향상된 for문---------");
    for(Book b : Library.books) {
      if(b.isEbook()) {
        System.out.println(b.getTitle());
      }
    }

    // stream
    System.out.println("---------필터---------");
    Library.books.stream()
        // .filter(b -> b.isEbook()
        .filter(Book::isEbook)
        // .forEach(b -> System.out.println(b.getTitle()));
        .forEach(Book::getTitle);

    // eBook인 책들의 가격을 출력해보세요.
    // 힌트: Stream<T> map(Function<? super T, ? extends R> mapper)
    Library.books.stream()
        .filter(Book::isEbook)
        .map(Book::getPrice)
        .forEach(System.out::println);

    // 스트림 정렬
    // comparable을 implements하는 경우
    System.out.println("---------정렬---------");
    Library.books.stream()
        .sorted()
        .forEach(System.out::println);
    // comparator를 직접 구현하는 경우
    Library.books.stream()
        // .sorted((b1, b2) -> b1.getPrice() - b2.getPrice())
        // .sorted(Comparator.comparingInt(Book::getPrice)) // 윗줄과 같은 역할
        .sorted(Comparator.comparing(Book::isEbook).reversed()) // 기본은 false부터, reversed는 true부터
        .forEach(System.out::println);
    System.out.println("---------toList()---------");
    List<Book> bookList = Library.books.stream()
        .sorted(Comparator.comparing(Book::isEbook).thenComparing(Book::getPublisher).reversed())
        .toList();
    Library.books.forEach(System.out::println);
    bookList.forEach(System.out::println);

    // 중복 제거
    System.out.println("---------중복 제거---------");
    List<Book> newBooks = Library.books.stream()
        .distinct()
        .toList();
    newBooks.forEach(System.out::println);

    // collect
    System.out.println("---------collect---------");
    Library.books.stream()
        .collect(Collectors.groupingBy(Book::getPublisher)) // collect의 리턴 타입은 map이다.
        // momo : {책 2권의 리스트}, mc: {책 4권의 리스트}
        .forEach((publisher, listByPublisher) -> {
          System.out.println(publisher);
          listByPublisher.forEach(System.out::println);
        });
    System.out.println("---------collect 2---------");
    Library.books.stream()
        .collect(Collectors.groupingBy(Book::getPublisher, Collectors.counting()))
        .forEach((publisher, count) -> {
          System.out.println(publisher);
          System.out.println(count);
        });
  }
}
