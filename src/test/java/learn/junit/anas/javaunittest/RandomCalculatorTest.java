package learn.junit.anas.javaunittest;

import learn.junit.anas.javaunittest.resolver.RandomParameterResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

//@Extensions({
//        @ExtendWith(RandomParameterResolver.class)
//})
public class RandomCalculatorTest extends AbstractCalculatorTest {

    //  private Calculator calculator = new Calculator();
    @Test
    void testRandom(Random random, TestInfo info) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);

    }

    @DisplayName("Test Random Calculator - 1")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke -> ( {currentRepetition} dari {totalRepetitions} )"
    )
    void testRandomRepeat(Random random, TestInfo info) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);

    }


    @DisplayName("Test Random Calculator - 2")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke -> ( {currentRepetition} dari {totalRepetitions} )"
    )
    void testRandomRepeatInfo(Random random, TestInfo info, RepetitionInfo repetitionInfo) {
        System.out.println(info.getDisplayName() + " ke -> " + repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);
        var expected = a + b;

        Assertions.assertEquals(expected, result);

    }

    //https://www.youtube.com/watch?v=0jreaBRIOTo&list=PL-CtdCApEFH-p_Q2GyK4K3ORoAT0Yt7CX&index=32
    // sampe menit 2.00.00


    // jika menggunakan cara value source
    @DisplayName("Test Calculator With Parameter")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = {1,2,3,4,65,8,9,22,334,4,})
    void testWithParameter(int value){
        var expected = value + value;
        var result = calculator.add(value,value);
        Assertions.assertEquals(expected,result);
    }


    // jika menggunakan cara method source harus buat method dulu sebelum melakukan test
    public static List<Integer> parameterSource(){
        return List.of(1,3,4,66,777,7,4);
    }

    @DisplayName("Test Calculator With Parameter")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @MethodSource("parameterSource")
    void testWithMethodSource(Integer value){
        var expected = value + value;
        var result = calculator.add(value,value);
        Assertions.assertEquals(expected,result);
    }
}
