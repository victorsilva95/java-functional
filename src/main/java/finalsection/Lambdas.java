package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {
        Function<String, String> upperCaseName = String::toUpperCase;

        BiFunction<String, Integer, String> upperCaseAndPrintAge = (name, age) -> {
            if(name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
        } ;


        System.out.println(upperCaseName.apply("victor"));
        System.out.println(upperCaseAndPrintAge.apply("hugo", 15));

    }
}
