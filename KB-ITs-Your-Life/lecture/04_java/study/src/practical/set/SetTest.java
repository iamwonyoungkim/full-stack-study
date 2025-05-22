package practical.set;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

  public static void main(String[] args) {
    Set<Building> buildingSet = new HashSet<>();

    buildingSet.add(new Building("A빌딩", "서울 중심구 중심로 777"));
    buildingSet.add(new Building("B빌딩", "서울 마포구 양화로 275"));
    buildingSet.add(new Building("A빌딩", "서울 중심구 중심로 777"));

    for(Building b : buildingSet) {
      System.out.println(b);
    }
  }

}
