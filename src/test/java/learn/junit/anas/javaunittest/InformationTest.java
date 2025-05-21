package learn.junit.anas.javaunittest;

import org.junit.jupiter.api.*;

import java.lang.reflect.Method;

@DisplayName("Information Test")
public class InformationTest {

    @Test
    @Tags({
            @Tag("One"),
            @Tag("Two")
    })
    @DisplayName("This is Test One")
    void testOne(TestInfo info){
        System.out.println(info.getDisplayName());
        System.out.println(info.getTags());
        System.out.println(info.getTestClass().orElse(null));
        System.out.println("Get Class --> "+info.getTestClass().map(Class::getSimpleName).orElse(null));
        System.out.println(info.getTestMethod().orElse(null));
        System.out.println("Get Method --> "+info.getTestMethod().map(Method::getName).orElse(null));
    }
}
