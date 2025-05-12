package learn.junit.anas.javaunittest;

import learn.junit.anas.javaunittest.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import  static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayName("Test Calculator") cara manual
public class CalculatorTest {
    private  Calculator calculator = new Calculator();

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
        // sampe menit 46:09
        //https://www.youtube.com/watch?v=0jreaBRIOTo&list=PL-CtdCApEFH-p_Q2GyK4K3ORoAT0Yt7CX&index=10
    }
}
