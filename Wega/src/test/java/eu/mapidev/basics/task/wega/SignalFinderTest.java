package eu.mapidev.basics.task.wega;

import java.io.File;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SignalFinderTest {

    public SimpleLineReader simpleLineReader;
    public List<String> lines;
    private final SignalFinder finder;

    public SignalFinderTest() {
	ClassLoader cl = ClassLoader.getSystemClassLoader();
	simpleLineReader = new SimpleLineReader(new File(
		cl.getResource("examples.txt").getPath()));
	lines = simpleLineReader.readAll();
	finder = new SignalFinder(lines);
    }

    @Test
    public void shouldAllowToFindSecretMessageFromWega() {
	String actualMessage = finder.readSecretMessage();
	assertThat(actualMessage, is("NIECHCIMATURAPROSTABEDZIE"));
    }

    @Test
    public void shouldFindTheMessageWithTheLargestNumberOfDifferentCharacters() {
	String actualMessage = finder.findMessageWithTheLargetstNumberOfDifferentCharacters();
	assertThat(actualMessage.length(), equalTo("AKLMNOPRSTWZA".length()));
	assertThat(actualMessage, is("AKLMNOPRSTWZA"));
    }

}
