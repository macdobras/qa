package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("ParameterizedClassTest")
public class ParameterizedClassTest extends ConfigJunit {

    @ParameterizedTest(name = "Parameterized test with value {0}")
    @DisplayName("First parameterized test")
    @ValueSource(ints = {5, 15, 25})
    public void paramFirstTest(int number){
        assertTrue( number % 5 == 0);
    }

    @ParameterizedTest(name = "Parameterized test with value {0}")
    @DisplayName("Second parameterized test")
    @ValueSource(strings = {"Hello", "Hello Junit", "Hello students"})
    public void paramSecondTest(String value){
        assertTrue(value.contains("Hello"));
    }

    @ParameterizedTest(name = "Parameterized test with values name: {0} and value {1}")
    @DisplayName("Csv value parameterized test")
    @CsvSource(value  = {"Hello, 5", "HelloJunit 5, 15", "'Hello 5!', 25"}, delimiter = ',')
    public void paramMultiArgTest(String param1, int param2){
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }

    @DisplayName("Csv value parameterized test")
    @ParameterizedTest(name = "Parameterized test with data from csv file, name: {0} and values {1}")
    @CsvFileSource(resources  = "/plik.csv", delimiter = ',')
    public void csvSourceTest(String param1, int param2) {
        assertTrue(param1.contains("Hello"));
        assertTrue(param2 % 5 == 0);
    }



}
