package com.sincro.practice;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class JSONParser {
    private static String JSON_FILE_NAME = "offers.json";
    private static DocumentContext documentContext;


    public JSONParser(){
        File file = getFileFromResources(JSON_FILE_NAME);
        try {
            String jsonData = FileUtils.readFileToString(file, "UTF-8");
            documentContext = JsonPath.parse(jsonData);
        } catch (IOException e) {
            System.out.print("Error in opening/reading file");
        }

    }

    private static File getFileFromResources(String jsonFileName) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL resource = classLoader.getResource(jsonFileName);
        if(resource == null){
            System.out.println("file not found!");
        }
        else{
            try {
                return new File(resource.toURI());
            } catch (URISyntaxException e) {
                System.out.println("URI syntax is not correct! Check your file name.");
            }
        }
        return null;
    }

    public <T> T getItemAtPath(String jsonPath){
        return documentContext.read(jsonPath);
    }

    public <T> List<T> getItemsListAtPath(String jsonPath){
        return documentContext.read(jsonPath);
    }

    public List<Map<String, Object>> getListOfMapsAtPath(String jsonPath){
        return documentContext.read(jsonPath);
    }
}
