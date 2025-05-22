package builder.builder2;

public class Main {

  public static void main(String[] args) {
    User user = User.builder()
        // 아래 요소들 순서 바뀌어도 괜찮고, 없어도 괜찮다(기본값이 있기 때문)
        .name("홍길동")
        .email("hong@scoula.org")
        .password("123456")
        .phone("010-1111-2222")
        .address("서울시")
        .sex(true)
        .age(16)
        .build(); // 여기서 User가 return 된다.

    System.out.println(user);
  }

}
