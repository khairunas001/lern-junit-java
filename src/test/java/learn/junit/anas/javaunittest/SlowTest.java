package learn.junit.anas.javaunittest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;


// @Execution(value = ExecutionMode.CONCURRENT) digunakan untuk menjalankan unit test secara parallel
@Execution(value = ExecutionMode.CONCURRENT)
public class SlowTest {

    @Test
    // digunaaakan untuk menentukan timeout dari sebuah uni test
    // jika lebih dari waktu yang sudah ditentukan maka unit test akan dianggap gagal
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testSlow1() throws InterruptedException {
        Thread.sleep(1_000);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testSlow2() throws InterruptedException {
        Thread.sleep(3_000);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testSlow3() throws InterruptedException {
        Thread.sleep(4_000);
    }

    //Pengenalan Mocking 2.15.00
    //https://www.youtube.com/watch?v=0jreaBRIOTo&list=PL-CtdCApEFH-p_Q2GyK4K3ORoAT0Yt7CX&index=34

    // Slide : https://docs.google.com/presentation/d/1jaRXrZbMDCAubVs3annSlP2Mw2aTl67lqW40ysVRvKg/edit?slide=id.g8c7c984eac_0_588#slide=id.g8c7c984eac_0_588
}
