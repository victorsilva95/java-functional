package streams;


import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;


public class _Stream {

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)


        );

        personList.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        boolean b = personList.stream()
                .noneMatch(person -> PREFER_NOT_TO_SAY.equals(person.gender));

        System.out.println(b);
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
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
