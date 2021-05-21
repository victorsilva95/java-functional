package finalsection;

import java.util.function.Consumer;

public class Callbacks {

    public static void main(String[] args) {
        hello("Victor", null, value -> System.out.println("No last name for " + value));
        hello2("Victor", null, () -> System.out.println("No last name found"));
    }

    //Javascript callbacks, in java functional interfaces
    static void hello(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);

        if(lastName != null){
            System.out.println(lastName);
        }
        else{
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback){
        System.out.println(firstName);

        if(lastName != null){
            System.out.println(lastName);
        }
        else{
            callback.run();
        }
    }
}
