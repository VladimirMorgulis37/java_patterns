package builder;

import java.util.Set;

public class Person {

    private String name;
    private String surname;
    private int age;
    private int height;
    private int weight;
    private Set<Person> parents;

    public static class Builder {
        private Person newPerson;

        public Builder() {
            newPerson = new Person();
        }

        public Builder withName(String name){
            newPerson.name = name;
            return this;
        }

        public Person build(){
            return newPerson;
        }
        public static void main(String[] args) {
            Person myPerson = new Person.Builder()
                    .withName("Jane")
                    .build();
            System.out.println(myPerson.name);
        }
    }
}