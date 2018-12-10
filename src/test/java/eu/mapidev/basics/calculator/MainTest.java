package eu.mapidev.basics.calculator;

import java.lang.reflect.Method;
import org.junit.Test;

public class MainTest {

    @Test
    public void shouldHaveMainMethod() throws NoSuchMethodException {
	Class<?> mainClass = Main.class;
	Method mainMethod = mainClass.getMethod("main", String[].class);
    }

}
