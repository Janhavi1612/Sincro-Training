package com.sincro.practice.schemaclasses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void shouldReturnLabelColoradoFromMeta(){
        assertEquals("Colorado",offersJsonRoot.getMeta().getOfferFilters().getCategories().get_new().getMakes().getChevrolet().getModels().getColorado().getLabel());
    }

    @Test
    void shouldReturn0ForGetPaginationOffset(){
        assertEquals(0,offersJsonRoot.getPaginationInfo().getOffset());
    }

    @Test
    void shouldReturnAppropriateListForStackableOffers(){
        List<Integer> expectedStackableOffers = new ArrayList<>(Arrays.asList(
                395438080,
                391037620,
                395441370,
                390088940,
                390088620,
                391034800));
        assertEquals(expectedStackableOffers, offersJsonRoot.getOffers().get(0).getStackableOffers());
    }

    @Test
    void shouldReturnCorrectRuleValueFromOfferFlexibleCriteria(){
        assertEquals("4ZR",offersJsonRoot.getOffers().get(0).getCriteria().get(0).getOfferFlexibleCriterias().get(1).getRuleValue());
    }

    @Test
    void shouldReturnCorrectListOfIncludedCountiesFromGeographicCriteria(){
        List<String> expectedIncludedCounties = new ArrayList<>(Arrays.asList(
                "OHWYANDOT",
                "OHWOOD",
                "OHWILLIAMS",
                "OHWAYNE",
                "OHWASHINGTON",
                "OHWARREN",
                "OHVINTON",
                "OHVAN WERT",
                "OHUNION",
                "OHTUSCARAWAS",
                "OHTRUMBULL",
                "OHSUMMIT",
                "OHSTARK",
                "OHSHELBY",
                "OHSENECA",
                "OHSCIOTO",
                "OHSANDUSKY",
                "OHROSS",
                "OHRICHLAND",
                "OHPUTNAM",
                "OHPREBLE",
                "OHPORTAGE",
                "OHPIKE",
                "OHPICKAWAY",
                "OHPERRY",
                "OHPAULDING",
                "OHOTTAWA",
                "OHNOBLE",
                "OHMUSKINGUM",
                "OHMORROW",
                "OHMORGAN",
                "OHMONTGOMERY",
                "OHMONROE",
                "OHMIAMI",
                "OHMERCER",
                "OHMEIGS",
                "OHMEDINA",
                "OHMARION",
                "OHMAHONING",
                "OHMADISON",
                "OHLUCAS",
                "OHLORAIN",
                "OHLOGAN",
                "OHLICKING",
                "OHLAWRENCE",
                "OHLAKE",
                "OHKNOX",
                "OHJEFFERSON",
                "OHJACKSON",
                "OHHURON",
                "OHHOLMES",
                "OHHOCKING",
                "OHHIGHLAND",
                "OHHENRY",
                "OHHARRISON",
                "OHHARDIN",
                "OHHANCOCK",
                "OHHAMILTON",
                "OHGUERNSEY",
                "OHGREENE",
                "OHGEAUGA",
                "OHGALLIA",
                "OHFULTON",
                "OHFRANKLIN",
                "OHFAYETTE",
                "OHFAIRFIELD",
                "OHERIE",
                "OHDELAWARE",
                "OHDEFIANCE",
                "OHDARKE",
                "OHCUYAHOGA",
                "OHCRAWFORD",
                "OHCOSHOCTON",
                "OHCOLUMBIANA",
                "OHCLINTON",
                "OHCLERMONT",
                "OHCLARK",
                "OHCHAMPAIGN",
                "OHCARROLL",
                "OHBUTLER",
                "OHBROWN",
                "OHBELMONT",
                "OHAUGLAIZE",
                "OHATHENS",
                "OHASHTABULA",
                "OHASHLAND",
                "OHALLEN",
                "OHADAMS"

        ));
        assertEquals(expectedIncludedCounties, offersJsonRoot.getOffers().get(0).getCriteria().get(1).getFlexibleCriteriaMap().getCounty().getIncludes());
    }

    @Test
    void shouldReturnProgramURLFromClientConfiguration(){
        String expectedProgramInfoUrl = "https://iomprod.gm-iom.com/tenpoint/tenPoint.pdf?programNumbers=20-40AAC-0&languageCode=en";
        assertEquals(expectedProgramInfoUrl,offersJsonRoot.getOffers().get(0).getClientConfiguration().getCustomConfigurations().getProgramInfoUrl());
    }
}