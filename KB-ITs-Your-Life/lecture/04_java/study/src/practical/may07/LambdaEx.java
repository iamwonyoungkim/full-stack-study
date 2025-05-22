package practical.may07;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaEx {
  // Consumer
  Consumer<String> consumer = x -> System.out.println(x);
  BiConsumer<String, Integer> biConsumer = (x, y) -> System.out.println(x + y);
  DoubleConsumer doubleConsumer = d -> System.out.println(d);
  IntConsumer intConsumer = i -> System.out.println(i);
  LongConsumer longConsumer = l -> System.out.println(l);

  // Supplier
  Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
  BooleanSupplier booleanSupplier = () -> true;
  DoubleSupplier doubleSupplier = () -> Math.random();
  IntSupplier intSupplier = () -> 1;
  LongSupplier longSupplier = () -> 1L;

  // Function
  Function<Integer, String> function = x -> "" + x;
  BiFunction<String, String, Integer> biFunction = (x, y) -> x.length() + y.length();
  DoubleFunction<String> doubleFunction = d -> "" + d;
  IntFunction<List<String>> intFunction = i -> List.of("a", "b", "c");
  LongFunction<String> longFunction = l -> "" + l;

  // Predicate
  Predicate<String> predicate = str -> true;
  BiPredicate<Integer, Integer> biPredicate = (x, y) -> x>y;
  DoublePredicate doublePredicate = d -> d >0;
  IntPredicate intPredicate = i -> i > 0;
  LongPredicate longPredicate = l -> l > 0;


  // Operator
  UnaryOperator<String> unaryOperator = x -> x.toUpperCase();
  BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
  IntUnaryOperator intUnaryOperator = x -> x + 1;
  LongUnaryOperator longUnaryOperator = l -> l + 1;
  DoubleUnaryOperator doubleUnaryOperator = d -> d + 1;

}
