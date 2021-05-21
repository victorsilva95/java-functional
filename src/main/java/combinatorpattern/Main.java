package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0898787879878",
                LocalDate.of(2018, 1, 1)
        );

        //Call methods validation tradicional
        System.out.println(new CustomerValidationService().isValid(customer));

        //Call method implementing combination pattern
        ValidationResult validationResult = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isDateValid())
                .apply(customer);

        if(SUCESS != validationResult){
            throw new IllegalArgumentException(validationResult.name());
        }
    }
}
