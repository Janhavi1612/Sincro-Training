package com.sincro.practice.utils;


import com.sincro.practice.Serialization.Student;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerializationUtil {
    private static Logger logger = Logger.getLogger(SerializationUtil.class.getName());
    private static String fileName = "/Users/dabakj/Janhavi1612LocalRepo/Serialization/serialization/src/main/resources/student.ser";


    public static Student deserialize(){

        try {
            return readStudentObject();
        } catch (FileNotFoundException e) {
            logger.log(Level.INFO, "File not found. Please ensure that file path is correct.");
        } catch (IOException e) {
            logger.log(Level.INFO, "Error occurred while opening the file.");
        } catch (ClassNotFoundException e) {
            logger.log(Level.INFO, "Error reading object as given class instance,");
        }

        return new Student();
    }

    private static Student readStudentObject() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student studentRead = (Student) objectInputStream.readObject();
        objectInputStream.close();

        return studentRead;
    }

    public static void serialize(Student student){
        try {
            writeStudentObject(student);
        } catch (FileNotFoundException e) {
            logger.log(Level.INFO, "File not found. Please ensure that file path is correct.");
        } catch (IOException e) {
            logger.log(Level.INFO, "Error occurred while opening the file.");
        }

    }

    private static void writeStudentObject(Student student) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

    }
}
