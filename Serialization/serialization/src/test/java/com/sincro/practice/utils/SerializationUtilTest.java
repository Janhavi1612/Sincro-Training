package com.sincro.practice.utils;

import com.sincro.practice.Name;
import com.sincro.practice.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializationUtilTest {
    private static Student student;
    private static SerializationUtil serializationUtill;

    @BeforeAll
    static void setup(){
        Name name = new Name("serialization","test");
        student = new Student(name, "C2K110","Computer");
        serializationUtill = new SerializationUtil();
    }

    @Test
    public void shouldReturnCorrectObjectValuesOnSerializeAndDeserialize(){
        serializationUtill.serialize(student);
        Student studentDeserialized = serializationUtill.deserialize();

        assertEquals("serialization",studentDeserialized.getName().getFirstName());
        assertEquals("test",studentDeserialized.getName().getLastName());
        assertEquals("C2K110",studentDeserialized.getRegistrationNumber());
        assertEquals("Computer",studentDeserialized.getDepartment());
    }

}