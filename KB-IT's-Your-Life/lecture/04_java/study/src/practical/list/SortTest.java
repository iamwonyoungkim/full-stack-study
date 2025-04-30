package practical.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest {

  public static void main(String[] args) {
    List<String> strList = new ArrayList<>();

    strList.add("B");
    strList.add("A");
    strList.add("C");

    Collections.sort(strList);

    for (String str : strList) {
      System.out.println(str);
    }
  }

}
