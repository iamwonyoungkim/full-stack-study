package practical.list;

import java.time.LocalDate;
import java.util.Comparator;

public class Review implements Comparable<Review>{

  int helpCount;
  LocalDate date;

  public Review(int helpCount, LocalDate date) {
    this.helpCount = helpCount;
    this.date = date;
  }

  @Override
  public String toString() {
    return "Review [helpCount=" + helpCount + ", date=" + date + "]";
  }

  // this.compareTo(Review);
  // this와 매개변수로 받은 Review의 데이터를 비교한다.
  @Override
  public int compareTo(Review review) {
    // 음수, 0, 양수 중에 하나를 return하도록 해야 한다.
    // return this.helpCount - review.helpCount;
    // return Integer.compare(helpCount, review.helpCount);
    return date.compareTo(review.date);
  }

  // helpCount가 높은 순
  static final Comparator<Review> HELP_COUNT_DESC_ORDER = new Comparator<Review>() {
    @Override
    public int compare(Review o1, Review o2) {
      // return Integer.compare(o1.helpCount, o2.helpCount); // 순정렬
      return Integer.compare(o2.helpCount, o1.helpCount); // 역정렬
    }
  };

  // 오래된 순
  static final Comparator<Review> DATE_ASC_ORDER = new Comparator<Review>() {
    @Override
    public int compare(Review o1, Review o2) {
      return o1.date.compareTo(o2.date); // 역정렬
    }
  };

}
