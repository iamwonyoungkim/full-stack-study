package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {

  public static void main(String[] args) {
    List<Student> totalList = new ArrayList<>();
    totalList.add(new Student("홍길동", "남", 92));
    totalList.add(new Student("김수영", "여", 87));
    totalList.add(new Student("감자바", "남", 95));
    totalList.add(new Student("오해영", "여", 93));

    // 남학생만 묶어 List 생성(stream 없이)
    List<Student> boyList = new ArrayList<>();
    for(Student s : totalList) {
      if(s.getSex().equals("남")) {
        boyList.add(s);
      }
    }
    for(Student s : boyList) {
      System.out.println(s.getName());
    }

    // 남학생만 묶어 List 생성(stream 사용)
    List<Student> maleList = totalList.stream()
        .filter(s -> s.getSex().equals("남"))
        .toList();

    // 출력 방법 1
    maleList.stream()
        .forEach(s -> System.out.println(s.getName()));
    // 출력 방법 2
    maleList.forEach(System.out::println); // 이렇게 하면 stream.Student@4fca772d와 같은 형태로 출력된다.
    // 출력 방법 3
    maleList.stream()
        .map(Student::getName)
        .forEach(System.out::println);

    // 성적 상위 2명 추출
    List<Student> topList = totalList.stream()
        .sorted((a, b) -> Integer.compare(b.getScore(), a.getScore())) // 내림차순
        .limit(2)
        .toList();
    topList.stream().map(Student::getName).forEach(System.out::println);

    // 학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
    Map<String, Integer> map = totalList.stream()
        .collect(Collectors.toMap(Student::getName, Student::getScore));
    System.out.println(map);
  }

}
