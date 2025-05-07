package lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

  public static void main(String[] args) {

    // xxxConsumer : 매개변수 o, 리턴형 x
    Consumer<String> consumer = x -> {
      System.out.println(x);
    };

    BiConsumer<String, Integer> biConsumer = (x, y) -> {
      System.out.println(x + y);
    };
    biConsumer.accept("", 0);

    IntConsumer intConsumer = x -> System.out.println(x);
    intConsumer.accept(0);

    DoubleConsumer doubleConsumer = x -> System.out.println(x);
    doubleConsumer.accept(0.0);

    // 매개변수가 기본이 아닌 객체 타입이다.
    // 아래의 경우 x가 String, y가 Double이다.
    ObjDoubleConsumer<String> objDoubleConsumer = (x, y) -> System.out.println(x);


    // xxxSupplier : 매개변수 x, 리턴값 o
    Supplier<Double> supplier = () -> Math.random(); // return 생략됨
    BooleanSupplier booleanSupplier = () -> Math.random() > 0.5;


    // Function : 매개변수 o, 리턴 o
    Function<String, Integer> function = x -> x.length();
    BiFunction<String, Integer, Integer> biFunction = (x, y) -> x.length() + y;
    BiFunction<Integer, String, Person> biFunction2 = (x, y) -> new Person(x, y);
    // 매개변수가 Int 타입, 리턴형이 String 타입
    IntFunction<String> intFunction = x -> "" + x;

    // Predicate : 매개변수 o, 리턴 o(boolean)
    Predicate<String> predicate = str -> str.length() > 5;
  }

}
