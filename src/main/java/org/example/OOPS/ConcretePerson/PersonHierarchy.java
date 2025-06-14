package org.example.OOPS.ConcretePerson;

import java.time.LocalDate;

/*
Key concepts used
Inheritance: Driver and Manager inherit attributes/methods from Person
Polymorphism: doWork() method provides role-specific behaviour
Encapsulation: Private attributes with public getters/setters control access to data
Abstraction: Generic doWork() in Person defines expected behavior, implemented differently in subclasses
 */

public class PersonHierarchy {
    public static void main(String[] args) {
        Person driver = new Driver("Akhil", 24, LocalDate.of(2000, 6, 19), "New Nagole");
        Person manager = new Manager("Dheeraj", 24, LocalDate.of(2000, 6, 21), "Dheeraj");
        driver.doWork();
        manager.doWork();
    }
}

class Person{
    private String name;
    private int age;
    private LocalDate dob;
    private String address;

    public Person(String name, int age, LocalDate dob, String address){
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.address = address;
    }

    public void doEat(){
        System.out.println(name + " is eating");
    }

    public void doSleep(){
        System.out.println(name + " is sleeping");
    }

    public void doWork(){
        System.out.println(name + " is working");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class Driver extends Person{

    public Driver(String name, int age, LocalDate dob, String address) {
        super(name, age, dob, address);
    }

    @Override
    public void doWork() {
        System.out.println(getName() + " is driving a vechile");
    }
}

class Manager extends Person{
    public Manager(String name, int age, LocalDate dob, String address){
        super(name, age, dob, address);
    }

    @Override
    public void doWork() {
        System.out.println(getName() + " is managing team and tasks");
    }
}
