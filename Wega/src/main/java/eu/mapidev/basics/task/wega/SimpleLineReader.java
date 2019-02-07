package eu.mapidev.basics.task.wega;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleLineReader {

    private final File file;

    public SimpleLineReader(File file) {
	this.file = file;
    }

    public List<String> readAll() {
	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    return br.lines().collect(Collectors.toList());
	} catch (IOException ex) {
	    throw new RuntimeException(ex);
	}
    }

}
