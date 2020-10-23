package com.sincro.practice.utils;

import com.sincro.practice.Externalization.Country;
import com.sincro.practice.Serialization.Student;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExternalizationUtil {
    private static Logger logger = Logger.getLogger(SerializationUtil.class.getName());
    private static String fileName = "/Users/dabakj/Janhavi1612LocalRepo/Serialization/serialization/src/main/resources/country.ser";

    public static void serialize(Country country){
        try {
            writeCountryObject(country);
        } catch (FileNotFoundException e) {
            logger.log(Level.INFO, "File not found. Please ensure that file path is correct.");
        } catch (IOException e) {
            logger.log(Level.INFO, "Error occurred while opening the file.");
        }
    }

    private static void writeCountryObject(Country country) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        country.writeExternal(objectOutputStream);
        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static Country deserialize(){
        try {
            return readCountryObject();
        } catch (FileNotFoundException e) {
            logger.log(Level.INFO, "File not found. Please ensure that file path is correct.");
        } catch (IOException e) {
            logger.log(Level.INFO, "Error occurred while opening the file.");
        } catch (ClassNotFoundException e) {
            logger.log(Level.INFO, "Error reading object as given class instance,");
        }

        return new Country();

    }

    private static Country readCountryObject() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Country countryRead = new Country();
        countryRead.readExternal(objectInputStream);
        objectInputStream.close();
        return countryRead;
    }

}
