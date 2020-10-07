package com.sincro.practice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONParserTest {
    private static JSONParser jsonParser;
    private String path;

    @BeforeAll
    static void setUp(){
        jsonParser = new JSONParser();
    }

    @Test
    void shouldReturn1ForMetaTotalResultsPath(){
        path = "$['meta']['totalResults']";
        assertEquals(1, jsonParser.<Integer>getItemAtPath(path));
    }

    @Test
    void shouldReturnArrayForOffersStackableOffers(){
        path = "$.offers[0].stackableOffers";
        List<Integer> expectedStackableOffers = new ArrayList<>(Arrays.asList(
                        395438080,
                        391037620,
                        395441370,
                        390088940,
                        390088620,
                        391034800)
        );
        assertEquals(expectedStackableOffers, jsonParser.<Integer>getItemsListAtPath(path));
    }

    @Test
    void shouldTypeOfCriteria(){
        path = "$.offers[0].criteria[1].type";
        assertEquals("GEOGRAPHIC",jsonParser.<String>getItemAtPath(path));
    }
}