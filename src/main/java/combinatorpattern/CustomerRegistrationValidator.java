package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid(){
        return customer -> customer.getEmail().contains("@") ? SUCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid(){
        return customer -> customer.getPhoneNumber().startsWith("+0") ? SUCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isDateValid(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ? SUCESS : DATE_NOT_VALID;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCESS) ? other.apply(customer) : result;
        };
    }



    enum ValidationResult{
        SUCESS,
        EMAIL_NOT_VALID,
        PHONE_NUMBER_NOT_VALID,
        DATE_NOT_VALID
    }
}
