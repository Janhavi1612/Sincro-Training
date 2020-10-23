package com.sincro.practice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {
    private Name name;
    private transient String registrationNumber;
    private String department;

    public Student(){
        this.name = new Name("","");
        this.registrationNumber="";
        this.department="";
    }

    public Student(Name name, String registrationNumber, String department) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.department = department;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.getRegistrationNumber());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        String registrationNumberRead = (String) objectInputStream.readObject();
        this.setRegistrationNumber(registrationNumberRead);
    }
}
