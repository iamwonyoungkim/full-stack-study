package practical.apr29.enumtype;

public class Movie {
  private final String title;
  private final Rating rating;

  public Movie(String title, Rating rating) {
    this.title = title;
    this.rating = rating;
  }

  public String getTitle() {
    return title;
  }

  public Rating getRating() {
    return rating;
  }

}
