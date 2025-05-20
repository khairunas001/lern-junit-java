package learn.junit.anas.javaunittest;


import learn.junit.anas.javaunittest.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;


@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class LifecycleTest {

    private String temp;

    @Test
    void testA(){
        temp = "Awikwok";
    }

    @Test
    void testB(){
        System.out.println(temp); //null
    }

    // jadi test pada junit tidak bisa berjalan secara berurutan sehingga
    // testB tidak bisa mengambil nilai temp = "Awikwok";
    // karena setiap test bersifat individual sehingga akan dilakukan pemanggilan setiap test,
    // sehingga tidak dapat menerima nilai sebelumnya di method sebelumnya

}
