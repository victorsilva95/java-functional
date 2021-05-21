package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //Function takes one argument and produces one result
        int increment = incementByOne(1);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multipleByTenFunction.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addOneAndMultiplyTen =
                incrementByOneFunction.andThen(multipleByTenFunction);
        System.out.println(addOneAndMultiplyTen.apply(4));

        //BiFunction takes two argument and produces one result
        System.out.println(incrementByOneAndMultiply(4,100));
        System.out.println(incrementByOneAndMultiply.apply(4, 100));
    }

    //Normal java function
    static int incementByOne(int number){
        return number + 1;
    }

    static Integer incrementByOneAndMultiply(int numberToIncrementByOne, int numberToMultiply){
        return (numberToIncrementByOne +1) * numberToMultiply;
    }

    //Function interface
    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;


    static Function<Integer, Integer> multipleByTenFunction = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply = (numberToIncrementByOne, numberToMultiply) ->  (numberToIncrementByOne +1) * numberToMultiply;
}
