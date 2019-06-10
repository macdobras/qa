package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("ParameterizedClassTest")
public class ParameterizedClassTest {

    @ParameterizedTest(name = "Parameterized test with value {0}")
    @DisplayName("First parameterized test")
    @ValueSource(ints = {5, 15, 25})
    public void pramFirstTest(int number){

        assertTrue( number % 5 == 0);

    }

    @ParameterizedTest(name = "Parameterized test with value {0}")
    @DisplayName("Second parameterized test")
    @ValueSource(strings = {"Hello", "Hello Junit", "Hello students"})
    public void pramSecondTest(String value){

        assertTrue(value.contains("Hello"));

    }
}
