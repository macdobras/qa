package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class JunitTest {

    final String stringTestowy = "stringTestowy";
    final String testowy = null;

    @Test
    @DisplayName("First junit test")
    public void firstTest(){

        assertTrue(true, "message for test result True");
        assertTrue(true);
        assertTrue(stringTestowy.equals("stringTestowy"), "message for test result True");
        assertTrue(5 == 2 + 3);
        assertFalse(false);
        assertFalse(stringTestowy.matches("^s"));
        assertEquals("stringTestowy", stringTestowy);
        assertSame("stringTestowy", stringTestowy);

    }

    @Test
    @DisplayName("Second junit test")
    @Disabled("...waiting for fixing")
    public void secondTest(){

        assertThat(stringTestowy).isEqualTo("stringTestowy");
        System.out.println(0.2 * 0.2);
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.04);
    }

    @Test
    @DisplayName("Failed junit test")
    public void FailedTest() {

        assertThat(stringTestowy).isEqualTo("stringTestowy");
        System.out.println(0.2 * 0.2);
        assertTrue(new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue() == 0.4);
    }

    @Test
    @DisplayName("Array junit test")
    @Tag("All")
    @RepeatedTest(5)
    public void arrayTest(){

        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5);

        assertTrue(list1.containsAll(list2));
        assertThat(list1).hasSize(5);
        assertThat(list2).containsAnyOf(1,2,3,4,5);

    }

    @Nested
    @DisplayName("Nested junit test")
    public class nestedSuiteClassTest {

        final String stringTestowy = "stringTestowy";

        @Test
        public void nestedTest(){
        assertThat(stringTestowy).isEqualTo("stringTestowy");
        }
    }

}
