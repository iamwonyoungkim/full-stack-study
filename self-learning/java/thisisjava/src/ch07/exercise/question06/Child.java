package ch07.exercise.question06;

public class Child extends Parent {

  public int studentNo;

  public Child(String name, int studentNo) {
    super(name); // 부모 클래스에 기본 생성자가 아닌, String을 매개변수로 하는 생성자밖에 없으므로, super를 사용해야 한다.
    this.name = name;
    this.studentNo = studentNo;
  }

}
