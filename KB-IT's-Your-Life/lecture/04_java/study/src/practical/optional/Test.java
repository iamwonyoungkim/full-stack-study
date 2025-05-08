package practical.optional;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class Test {

  public static void main(String[] args) {
    // Optional.of(null)은 사용 x, Optional.empty()를 사용한다.
    Optional<String> opt = Optional.of("abc");

    OptionalInt optInt = OptionalInt.of(10);
    OptionalLong optLong = OptionalLong.of(10L);

    OptionalDouble optionalDouble = OptionalDouble.empty();
    // OptionalDouble optionalDouble = OptionalDouble.of(1.0);

    double value1 = optionalDouble.orElse(0.0); // 값이 없을 때 default 값을 0.0으로 설정해준다.
    System.out.println(value1);
    double value2 = optionalDouble.orElseGet(() -> Math.PI); // 값이 없을 때 Math.PI를 리턴
    System.out.println(value2);
    try {
      double value3 = optionalDouble.orElseThrow(
          () -> new IllegalArgumentException("값이 없습니다.")
      );
      System.out.println(value3);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

}
