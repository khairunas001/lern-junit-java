package learn.junit.anas.javaunittest;

import learn.junit.anas.javaunittest.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({
        @Tag("integration-test")
})
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class SampleIntegrationTest {

    @Test
    public void sampleIntegrationTest1(){

    }

    @Test
    public void sampleIntegrationTest2(){

    }
    //sampe menit 01:20:00
    //https://www.youtube.com/watch?v=0jreaBRIOTo&list=PL-CtdCApEFH-p_Q2GyK4K3ORoAT0Yt7CX&index=13
}
