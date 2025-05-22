package learn.junit.anas.javaunittest;

import learn.junit.anas.javaunittest.resolver.RandomParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

import java.util.Random;

//@Extensions({
//        @ExtendWith(RandomParameterResolver.class)
//})
public class RandomCalculatorTest extends AbstractCalculatorTest{

    //  private Calculator calculator = new Calculator();
    @Test
    void testRandom(Random random, TestInfo info){
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected,result);

    }

    @DisplayName("Test Random Calculator - 1")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke -> ( {currentRepetition} dari {totalRepetitions} )"
    )
    void testRandomRepeat(Random random, TestInfo info){
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected,result);

    }


    @DisplayName("Test Random Calculator - 2")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke -> ( {currentRepetition} dari {totalRepetitions} )"
    )
    void testRandomRepeatInfo(Random random, TestInfo info, RepetitionInfo repetitionInfo){
        System.out.println(info.getDisplayName()+" ke -> "+ repetitionInfo.getCurrentRepetition() +" dari "+ repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected,result);

    }

    //https://www.youtube.com/watch?v=0jreaBRIOTo&list=PL-CtdCApEFH-p_Q2GyK4K3ORoAT0Yt7CX&index=32
    // sampe menit 2.00.00
}
