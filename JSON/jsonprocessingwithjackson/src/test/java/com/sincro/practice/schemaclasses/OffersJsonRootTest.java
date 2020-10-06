package com.sincro.practice.schemaclasses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_METHOD;

class OffersJsonRootTest {
    private static String filePath = "offers.json";
    private static byte[] jsonData;
    private static ObjectMapper objectMapper;
    private static OffersJsonRoot offersJsonRoot;
    private static Logger logger = Logger.getLogger(OffersJsonRootTest.class.getName());

    @BeforeAll
    private static void setup(){
        try {
            jsonData = Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            logger.log(Level.INFO, "Error in opening source file, check the file path.");
        }
        objectMapper = new ObjectMapper();
        try {
            offersJsonRoot = objectMapper.readValue(jsonData,OffersJsonRoot.class);
        } catch (IOException e) {
            logger.log(Level.INFO,"error in reading file from json file.");
        }
    }

    @Test
    void shouldReturn1ForGetTotalResultsOnMeta(){
        assertEquals(1,offersJsonRoot.getMeta().getTotalResults());
    }

    @Test
    void shouldReturnAppropriateResultForGetOfferIdsFromQuery(){
        List<Integer> expectedOfferIds = new ArrayList<>(Arrays.asList(395437940));
        assertEquals(expectedOfferIds,offersJsonRoot.getMeta().getQuery().getOfferIds());
    }
}