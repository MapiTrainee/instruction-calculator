package eu.mapidev.basics.calculator.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SimpleReaderTest {
    
    @Test
    public void shouldReadLinesFromTempFile() throws IOException {
	File tmp = File.createTempFile("test", null);
	String[] expectedLines = {"First", "Second", "Third"};
	writeLinesToFile(expectedLines, tmp);
	SimpleReader sr = new SimpleReader(tmp);
	List<String> actualLines = sr.readLines();
	assertThat(actualLines, is(Arrays.asList(expectedLines)));
    }
    
    private void writeLinesToFile(String[] lines, File file) throws FileNotFoundException {
	PrintWriter pw = new PrintWriter(file);
	for (String line : lines) {
	    pw.println(line);
	}
	pw.close();
    }
    
}
