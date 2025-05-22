package practical.apr29.enumtype;

// 영화 관람 등급
public enum Rating {
  ALL("전체관람가", 0),
  TWELVE("12세 이상 관람가", 12),
  FIFTEEN("15세 이상 관람가", 15),
  ADULT("청소년 관람 불가", 18)  ;

  //enum도 클래스처럼 변수, 생성자, 메소드를 생성할 수 있다.

  // 변수 선언
  private String desc;
  private int minAge;

  // 생성자 선언
  Rating(String desc, int minAge) {
    this.desc = desc;
    this.minAge = minAge;
  }

  @Override
  public String toString() {
    return "Rating{" +
        "name ='" + name() + '\'' +
        ", desc='" + desc + '\'' +
        ", minAge=" + minAge +
        '}';
  }

  // 메소드 선언
  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public int getMinAge() {
    return minAge;
  }

  public void setMinAge(int minAge) {
    this.minAge = minAge;
  }

  public static void main(String[] args) {
    // enum은 equals() 혹은 ==을 사용해서 비교할 수 있다.

    // values를 이용하면 enum의 모든 값들이 배열로 들어간다.
    Rating[] values = Rating.values();
    for (Rating r : values) {
      System.out.println(r.toString());
    }

    // String을 enum으로 변환하는 메소드
    Rating rating = Rating.valueOf("ALL");
    System.out.println(rating.toString());
  }
}
