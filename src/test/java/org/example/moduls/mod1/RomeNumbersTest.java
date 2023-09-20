package org.example.moduls.mod1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

class RomeNumbersTest {

    @Test
    public void romeToArabicWorkWithITest() {

        int actual = new RomeNumbers().romeToArabic("I");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void romeToArabicWorkWithIITest() {

        int actual = new RomeNumbers().romeToArabic("II");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void arabicValuesToRomeAllTest() {
        Map<String, Integer> values = new LinkedHashMap<>();
        values.put("I", 1);
        values.put("II", 2);
        values.put("III", 3);
        values.put("IV", 4);
        values.put("V", 5);
        values.put("VI", 6);
        values.put("VII", 7);
        values.put("VIII", 8);
        values.put("IX", 9);
        values.put("X", 10);
        values.put("DXXV", 525);
        values.put("XLIV", 44);
        values.put("CMXCIX", 999);
        values.put("MI", 1001);

        values.forEach((rome, expectedArabic) -> Assertions.assertEquals(expectedArabic,
                new RomeNumbers().romeToArabic(rome), "Problem with -> arabic value " + expectedArabic));
    }

    @Test
    public void romeToArabicValuesAllTest() {
        Map<String, Integer> values = new LinkedHashMap<>();
        values.put("I", 1);
        values.put("II", 2);
        values.put("III", 3);
        values.put("IV", 4);
        values.put("V", 5);
        values.put("VI", 6);
        values.put("VII", 7);
        values.put("VIII", 8);
        values.put("IX", 9);
        values.put("X", 10);
        values.put("CCLXXIX", 279);
        values.put("DCCLXXXIV", 784);
        values.put("DXXV", 525);
        values.put("XLIV", 44);
        values.put("CMXCIX", 999);
        values.put("MI", 1001);

        values.forEach((rome, expectedArabic) -> Assertions.assertEquals(expectedArabic,
                new RomeNumbers().romeToArabic(rome), "Problem with -> rome value " + rome));
    }
}