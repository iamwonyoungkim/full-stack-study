package practical.apr30.ch15.sec03.exam02;

import java.util.Objects;

public class Member {
  public String name;
  public int age;

  public Member(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Member member)) {
      return false;
    }
    return age == member.age && Objects.equals(name, member.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}
