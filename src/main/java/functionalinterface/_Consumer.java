package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "99999");
        greetCustomer(maria);
        greetCustomerConsumer.accept(maria);
        greetCustomerConsumerV2.accept(maria, true);
    }

    //Normal java function
    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number "+ customer.customerPhonerNumber);
    }

    static void greetCustomerV2(Customer customer, Boolean showPhoneNumber){
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number "+
                (showPhoneNumber ? customer.customerPhonerNumber : "*****"));
    }

    //Functional interface
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "+
                    customer.customerPhonerNumber);

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number "+
                    (showPhoneNumber ? customer.customerPhonerNumber : "*****"));

      static class Customer{
        private final String customerName;
        private final String customerPhonerNumber;


        Customer(String customerName, String customerPhonerNumber) {
            this.customerName = customerName;
            this.customerPhonerNumber = customerPhonerNumber;
        }
    }
}
