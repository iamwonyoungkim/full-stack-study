package lambda;

import java.util.function.BiFunction;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

public class Test {

  public static void main(String[] args) {
    // 메소드 참조
    IntConsumer intConsumer
        // = x -> System.out.println(x);
        // = x -> A.mA(x);
        = A::mA;

    A a = new A();
    LongConsumer longConsumer
        // = y -> System.out.println(y);
        // = y -> a.mB(y);
        = a::mB;

    ObjDoubleConsumer<A> objDoubleConsumer
        // = (obj, d) -> obj.mC(d);
        = A::mC;

    // 생성자 참조
    // supplier는 매개변수가 없으므로, 매개변수가 없는 생성자를 호출한다.
    Supplier<A> supplier
        // = () -> new A();
        = A::new;
    supplier.get();

    // 매개변수가 int이므로, 매개변수가 Integer 하나인 생성자를 호출한다.
    IntFunction<A> intFunction
        = A::new;
    intFunction.apply(0);

    // 매개변수가 String, Integer인 생성자를 호출한다.
    BiFunction<String, Integer, A> biFunction
        = A::new;
    biFunction.apply("", 0);
  }

}
