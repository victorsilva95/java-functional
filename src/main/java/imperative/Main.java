package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)


        );

        System.out.println("// Imperative approach");

        // Imperative approach
        List<Person> femaleList = new ArrayList<>();
        for ( Person person: personList){
            if(person.gender.equals(FEMALE)){
                femaleList.add(person);
            }
        }

        for (Person female : femaleList){
            System.out.println(female);
        }

        System.out.println("// Declarative approach");

        // Declarative approach
        personList.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender){
            this.gender = gender;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
