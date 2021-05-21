package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        //Normal java function call
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("09000000000"));

        //Functional interface call
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000000000"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumberThree).test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.and(containsNumberThree).test("07000000003"));

    }

    //Normal java function
    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    //Functional interface
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    static Predicate<String> containsNumberThree = phoneNumber ->
            phoneNumber.contains("3");
}
