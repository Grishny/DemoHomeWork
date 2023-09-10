package exemples;

import org.junit.jupiter.api.*;

public class JUnit5Exemples {
    @BeforeAll
    static void setup(){
        System.out.println("setup");
    }

    @BeforeEach
    void beforeEach (){
        System.out.println("beforeEach");
    }


    @Test
    void firstTest() {
        System.out.println("____firstTest");
    }

    @Test
    void secondTest() {
        System.out.println("____secondTest");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

    @AfterAll
    static void tearDown(){
        System.out.println("tearDown");
    }
}

