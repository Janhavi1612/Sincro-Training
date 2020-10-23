package com.sincro.practice.utils;

import com.sincro.practice.Externalization.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExternalizationUtilTest {

    private static Country country;
    private static ExternalizationUtil externalizationUtil;

    @BeforeAll
    static void setup(){
        country = new Country("India", 411);
        externalizationUtil = new ExternalizationUtil();
    }

    @Test
    public void shouldSerializeAndDeserializeExternalizableObject(){
        externalizationUtil.serialize(country);
        Country countryDeserialized = externalizationUtil.deserialize();

        assertEquals("India",countryDeserialized.getName());
    }

}