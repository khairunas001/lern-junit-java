package learn.junit.anas.javaunittest;

import org.junit.jupiter.api.*;

@Tags({
        @Tag("Ordered-Test")
})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    @Test
    @Order(1)
    void test3(){

    }

    @Test
    @Order(2)
    void test2(){

    }

    @Test
    @Order(3)
    void test1(){

    }

}
