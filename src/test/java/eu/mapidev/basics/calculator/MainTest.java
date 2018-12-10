package eu.mapidev.basics.calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class MainTest {

    private PrintStream out = System.out;
    private ByteArrayOutputStream os;

    @Test
    public void shouldHaveMainMethod() throws NoSuchMethodException {
	Class<?> mainClass = Main.class;
	Method mainMethod = mainClass.getMethod("main", String[].class);
    }

    @Test
    public void shouldPrintUsageWhenIncorrectInputArgs() {
	setFixedSystemOut();
	Main.main(new String[0]);
	String actualMessage = getMessageFromFixedSystemOut();
	restoreDefaultSystemOut();
	assertThat(actualMessage, is(Main.USAGE_MESSAGE));
    }

    @Test
    public void shouldPrintCorrectOutputForInputTxt() {
	setFixedSystemOut();
	Main.main(new String[]{"input.txt"});
	String actualMessage = getMessageFromFixedSystemOut();
	restoreDefaultSystemOut();
	assertThat(actualMessage, is("Output: 36"));
    }

    public void setFixedSystemOut() {
	os = new ByteArrayOutputStream();
	System.setOut(new PrintStream(os));
    }

    public String getMessageFromFixedSystemOut() {
	return os.toString();
    }

    private void restoreDefaultSystemOut() {
	System.setOut(out);
    }
}
