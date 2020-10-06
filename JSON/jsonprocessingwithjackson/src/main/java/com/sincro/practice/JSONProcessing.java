package com.sincro.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sincro.practice.schemaclasses.OffersJsonRoot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONProcessing {
    private static String filePath = "offers.json";
    public static void main(String[] args) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        OffersJsonRoot rootOffers = objectMapper.readValue(jsonData, OffersJsonRoot.class);

    }
}
