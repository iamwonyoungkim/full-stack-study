package practical.list;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReviewTest {

  public static void main(String[] args) {
    List<Review> reviews = new ArrayList<>();

    reviews.add(new Review(5, LocalDate.of(2025, 10, 10)));
    reviews.add(new Review(1, LocalDate.of(2025, 10, 17)));
    reviews.add(new Review(3, LocalDate.of(2025, 10, 12)));
    reviews.add(new Review(9, LocalDate.of(2025, 10, 21)));
    reviews.add(new Review(3, LocalDate.of(2025, 10, 15)));

    Collections.sort(reviews); // 날짜 최신순. Review 클래스의 compareTo(Review review) 메소드 이용
    for(Review review : reviews) {
      System.out.println(review);
    }

    System.out.println();

    reviews.sort(Review.HELP_COUNT_DESC_ORDER); // helpCount 높은 순
    for(Review review : reviews) {
      System.out.println(review);
    }

    System.out.println();

    reviews.sort(Review.DATE_ASC_ORDER); // 오래된 순
    for(Review review : reviews) {
      System.out.println(review);
    }
  }
}
