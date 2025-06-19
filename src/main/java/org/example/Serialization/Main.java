package org.example.Serialization;

import lombok.Data;

import java.io.*;
import java.time.LocalDate;

public class Main{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Address address = new Address("Hyderabad", "Telangana");
        Employee employee = new Employee();
        employee.setName("Akhil");
        employee.setEmpId("123");
        employee.setDob(LocalDate.of(2000,6,19));
        employee.setAddress(address);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.ser"));
        oos.writeObject(employee);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.ser"));
        Employee deserialized = (Employee) ois.readObject();
        ois.close();

    }
}

@Data
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient String empId;
    private LocalDate dob;
    private Address address;
}


class Address implements Serializable{
    private static final long serialVersionUID = 1L;
    private String city;
    private String state;

    public Address(String state, String city) {
        this.state = state;
        this.city = city;
    }
}
