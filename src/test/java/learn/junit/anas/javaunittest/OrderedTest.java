package learn.junit.anas.javaunittest;

import org.junit.jupiter.api.*;

@Tags({
        @Tag("Ordered-Test")
})
//@TestInstance(value = TestInstance.Lifecycle.PER_METHOD) DEFAULT
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class OrderedTest {

    private int counter;

    //  @BeforeAll dan @AfterAll harus menggunakan static, tapi jika lifecycle diatur tiap Class maka tanpa static bisa dilakukan
    @BeforeAll
    void beforeAll(){
        System.out.println("=======BEFORE ALL==========");
    }

    @AfterAll
    void afterAll(){
        System.out.println("=======AFTER ALL==========");
    }

    // LIFECYLE KETIKA MENGGUNAKAN PER METHOD AKAN DIBUAT OBJEK BARU SETIAP METHOD DIPANGGIL
    //    OrderedTest test3 = new OrderedTest();
    //    test3.test3();
    //
    //    OrderedTest test2 = new OrderedTest();
    //    test2.test2();
    //
    //    OrderedTest test1 = new OrderedTest();
    //    test1.test1();

    // LIFECYLE KETIKA MENGGUNAKAN PER CLASS AKAN DIBUAT SEKALI PADA CLASS
    //    OrderedTest test = new OrderedTest();
    //    test.test3();
    //    test.test2();
    //    test.test1();

    @Test
    @Order(1)
    void test3(){
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(2)
    void test2(){
        counter++;
        System.out.println(counter);
    }

    @Test
    @Order(3)
    void test1(){
        counter++;
        System.out.println(counter);
    }

}
