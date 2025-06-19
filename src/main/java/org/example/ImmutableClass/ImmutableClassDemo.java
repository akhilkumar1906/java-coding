package org.example.ImmutableClass;

import java.util.*;

final class VulnerableStudent{
    private final String name;
    private final Date birthDate; // Mutable Object
    private final List<String> courses; // Mutable collection

    public VulnerableStudent(String name, Date birthDate, List<String> courses) {
        this.name = name;
        this.birthDate = birthDate; // direct reference
        this.courses = courses; // direct reference
    }

    public String getName() {
        return name;
    }

    // Getter expose mutable objects
    public Date getBirthDate() { return birthDate; }

    public List<String> getCourses() { return courses; }
}

final class SafeStudent{
    private final String name;
    private final Date birthDate;
    private final List<String> courses;

    SafeStudent(String name, Date birthDate, List<String> courses) {
        this.name = name;

        //Defensive copy for Date
        this.birthDate = new Date(birthDate.getTime());

        //Defensive copy for list
        this.courses = new ArrayList<>(courses);
    }

    // Return defensive copies/unmodifiable views
    public Date getBirthDate() {
        return new Date(birthDate.getTime());
    }

    public List<String> getCourses() {
//        return new ArrayList<>(courses);
        return Collections.unmodifiableList(courses); // return read-only view
    }
}


public class ImmutableClassDemo {
    public static void main(String[] args) {
        System.out.println("===VULNERABLE EXAMPLE===");
        Date birthDate = new Date(2000,6, 19);
        List<String> courses = new ArrayList<>(Arrays.asList("Math", "Science"));
        VulnerableStudent vs = new VulnerableStudent("Akhil", birthDate, courses);

        System.out.println("Original birth year: " + vs.getBirthDate().getYear());
        System.out.println("Original courses: " + vs.getCourses());

        // Attack through references
        birthDate.setYear(2005);
        courses.add("Social");
        vs.getCourses().add("Hacking");

        System.out.println("Modified birth year: " + vs.getBirthDate().getYear());
        System.out.println("Modified courses: " + vs.getCourses());

        System.out.println("===SAFE EXAMPLE===");

        Date safeBirthDate = new Date(2001,6,21);
        List<String> safeCourses = new ArrayList<>(Arrays.asList("Maths", "Chemistry"));

        SafeStudent ss = new SafeStudent("Dheeraj", safeBirthDate, safeCourses);

        System.out.println("Original birth year: " + ss.getBirthDate().getYear());
        System.out.println("Original courses: " + ss.getCourses());

        vs.getBirthDate().setYear(2000);
        safeCourses.add("Hacking");
        ss.getCourses().add("Cheating");

        System.out.println("Modified birth year: " + ss.getBirthDate().getYear());
        System.out.println("Modified courses: " + ss.getCourses());

    }
}