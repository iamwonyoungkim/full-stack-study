package practical.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

// 직렬화
public class Test {

  public static void main(String[] args) {
//    try (
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./src/practical/io/member.ser"));
//    ) {
//      Member member = new Member();
//      member.name = "홍길동";
//      member.age = 0;
//
//      //정보를 객체 단위로 읽고 쓸 때 사용한다.
//      oos.writeObject(member);
//      System.out.println("객체가 직렬화 되었습니다.");
//    } catch(Exception e) {
//      throw new RuntimeException(e);
//    }

    try(
        FileInputStream fis = new FileInputStream("./src/practical/io/member.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ) {

      Member member = (Member) ois.readObject(); // Member 타입으로 강제 형변환 해줘야 한다.
      System.out.println("이름: " + member.name);
      System.out.println("나이: " + member.age);

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
