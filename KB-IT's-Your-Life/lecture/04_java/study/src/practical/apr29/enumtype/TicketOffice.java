package practical.apr29.enumtype;

public class TicketOffice {
  public static void buyTicket(Movie movie, int viewerAge) {
    if(movie.getRating().getMinAge() <= viewerAge) {
      System.out.println("돈 내세요~");
    } else {
      System.out.println("못 사세요~");
    }
  }

}
