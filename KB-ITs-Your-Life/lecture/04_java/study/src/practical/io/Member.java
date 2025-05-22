package practical.io;

import java.io.Serializable;

public class Member implements Serializable {
  String name;
  int age;
  // transient String address;
  // transient를 사용하면 얘는 직렬화에서 제외된다.

}
