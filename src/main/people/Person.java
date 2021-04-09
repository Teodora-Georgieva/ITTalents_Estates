package main.people;

import main.utils.Validator;

import java.util.Objects;

public abstract class Person {
    private String name;
    private String phoneNumber;
    protected double money;

    Person(String name, double money){
        if(Validator.isValidString(name)) {
            this.name = name;
        }
        else{
            this.name = "Ivan";
        }

        this.phoneNumber = "0885112233";

        if(money > 0){
            this.money = money;
        }
    }

    @Override
    public boolean equals(Object o) {
        //System.out.println("Calling equals() of Person");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        //System.out.println("Calling hashCode() of Person");
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }
}