package com.jsystems.qa.qajunit;

import org.junit.jupiter.api.*;

public class ConfigJunit  {

    @BeforeAll
    public static void setUpAll(TestInfo testInfo){
        System.out.println("============= BeforeAll ============= ");
        System.out.println("DisplayName: " + testInfo.getDisplayName());
        System.out.println("Test Name class name: " + testInfo.getTestClass());
        System.out.println("=====================================");
    }

    @AfterAll
    public static void tearDownAll(){
        System.out.println("============= AfterAll ============= ");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("============= BefortEach ============= ");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("============= AfterEach ============= ");
    }

}
