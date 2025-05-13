package learn.junit.anas.javaunittest;

import learn.junit.anas.javaunittest.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import  static org.junit.jupiter.api.Assertions.*;
import  static org.junit.jupiter.api.Assumptions.*;


@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayName("Test Calculator") cara manual
public class CalculatorTest {
    private  Calculator calculator = new Calculator();

    // @BeforeAll dan @AfterAll digunakan untuk menandai awal dan akhir test keseluruhan jadi hanya dilakukan sekali
    // bukan setiap method test
    @BeforeAll
    public static void beforeAll(){
        System.out.println("=======BEFORE ALL==========");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("=======AFTER ALL==========");
    }


    // @BeforeEach dan @AfterEach digunakan untuk penanda mulai dan akhir test pada tiap method atau unit test
    @BeforeEach
    public void setUp(){
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After Each\n");
    }

    @Test
//    @DisplayName("Test for succes method add()") cara manual
    public void testAddSucces(){
        var result = calculator.add(10,29);
        assertEquals(39,result);
        // cara manual
        //        if(result != 39){
        //            throw new RuntimeException("Test gagal");
        //        }
        System.out.println("add method Success");
    }

    @Test
    public void testMinusSucces(){
        var result = calculator.minus(10,29);
        assertEquals(-19,result);
        System.out.println("minus method Success");
    }

    @Test
    public void testTimesSucces(){
        var result = calculator.times(10,29);
        assertEquals(290,result);
        System.out.println("times method Success");
    }

    @Test
    public void testDevidedSucces(){
        var result = calculator.divided(10,5);
        assertEquals(2,result);
        System.out.println("devided method Success");
    }

    @Test
    public void testDevideFailed(){
        assertThrows(IllegalArgumentException.class, () ->{
            calculator.divided(10,0);
        });
        System.out.println("devided method failed cannot devided by zero");
    }

    @Test
    @Disabled //untuk menonaktifkan unit test
    public void comingSoon(){
        //kapan yahhh
    }

    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE"); // Mendapatkan environment variable dengan nama PROFILE.
        if(!"DEV".equals(profile)){
            //Jika PROFILE bukan DEV, maka test dibatalkan dengan melempar TestAbortedException.
            // Assumptions.assumeTrue("DEV".equals(profile), "TEST dibatalkan karena bukan DEV");
            throw new TestAbortedException("TEST dibatalkan karena bukan DEV");
        }
        //Mengecek bahwa isi dari variabel profile benar-benar "DEV".
        //Jika tidak, maka test akan gagal.
        assertEquals("DEV",profile);
        System.out.println("Test berhasil");
    }

    @Test
    public void testAdd2(){
        var result = calculator.add(10,10);
        if(!result.equals(20)){
            throw new TestAbortedException("Test gagal karena hasilnya tidak sesuai");
        }

        assertEquals(20,result);
        System.out.println("Test Succes");
    }

    @Test
    public void testAssumptions(){
        var profile = System.getenv("PROFILE");
        System.out.println("PROFILE = " + profile); // Debug cetakan

        assumeTrue("DEV".equals(System.getenv("PROFILE")));
        assertEquals("DEV",profile);
        System.out.println("Test Succes");

    }
}
