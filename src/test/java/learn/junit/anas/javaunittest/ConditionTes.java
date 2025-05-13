package learn.junit.anas.javaunittest;

import learn.junit.anas.javaunittest.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class ConditionTes {

    @Test
    void testSystemProperties(){
        Properties properties = System.getProperties();
        properties.forEach((key,value) -> System.out.println(key + " -> "+value));
    }

    // test untuk mengijinkan atau mematikan unit test berdasarkan os yang digunakan
    @Test
    @EnabledOnOs(value = {OS.WINDOWS})
    public void testRunOnlyWindows(){
        //PUT YOURS UNIT TEST
    }

    @Test
    @DisabledOnOs(value = {OS.WINDOWS})
    public void testDisabledWindows(){
        //PUT YOURS UNIT TEST

    }

    // test yang mengijinkan atau mematikan unit test sesuai dengan versi java atau JRE yang digunakan

    @Test
    @EnabledOnJre(value = {JRE.JAVA_24})
    public void onlyRunOnJava24(){
        //PUT YOURS UNIT TEST
    }

    @Test
    @DisabledOnJre(value = {JRE.JAVA_24})
    public void disabledRunOnJava24(){
        //PUT YOURS UNIT TEST
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_24)
    public void onlyRunOnJava8toJava24(){
        //PUT YOURS UNIT TEST
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_24)
    public void disabledRunOnJava8toJava24(){
        //PUT YOURS UNIT TEST
    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testEnabledOnJavaVendorOracle(){
        //PUT YOURS UNIT TEST
    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testDisabledOnJavaVendorOracle(){
        //PUT YOURS UNIT TEST
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void enabledOnProfileDev(){
        //PUT YOURS UNIT TEST
    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void disabledOnProfileDev(){
        //PUT YOURS UNIT TEST
    }
}
