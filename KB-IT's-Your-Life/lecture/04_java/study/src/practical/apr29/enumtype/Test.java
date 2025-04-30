package practical.apr29.enumtype;

public class Test {

  public static void main(String[] args) {
    // 영화 이름, 등급 정함
    Movie movie = new Movie("타이타닉", Rating.FIFTEEN);

    // 티켓을 사려고 온 사람이 해당 영화를 볼 수 있는 나이인지 검사
    TicketOffice.buyTicket(movie, 15);
  }

}
