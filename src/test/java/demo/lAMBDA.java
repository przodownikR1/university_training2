package demo;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class lAMBDA {
    public static void main(String[] args) {
        BiFunction<String, String, String> concat = (a, b) -> a + b;
        greetFolks(whom -> concat.apply("Hello, ", whom));
        greetFolks2();
    }

    public static void greetFolks(Function<String, String> greeter) {
        for (String name : Arrays.asList("Alice", "Bob", "Cathy")) {
            System.out.println(greeter.apply(name));
        }
    }

    public static void greetFolks2() {
        Consumer<String> doGreet = name -> System.out.println("Hello, " + name);
        for (String name : Arrays.asList("Alice", "Bob", "Cathy")) {
            doGreet.accept(name);
        }
    }
}
