package eu.mapidev.basics.task.wega;

import java.io.File;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SignalFinderTest {

    public SimpleLineReader simpleLineReader;
    public List<String> lines;

    public SignalFinderTest() {
	ClassLoader cl = ClassLoader.getSystemClassLoader();
	simpleLineReader = new SimpleLineReader(new File(
		cl.getResource("examples.txt").getPath()));
	lines = simpleLineReader.readAll();
    }

    @Test
    public void shouldAllowToFindSecretMessageFromWega() {
	SignalFinder sf = new SignalFinder(lines);
	String actualMessage = sf.readSecretMessage();
	assertThat(actualMessage, is("NIECHCIMATURAPROSTABEDZIE"));
    }

}
