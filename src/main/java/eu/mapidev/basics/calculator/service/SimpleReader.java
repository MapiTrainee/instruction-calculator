package eu.mapidev.basics.calculator.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SimpleReader {

    private File file;

    public SimpleReader(File file) {
	this.file = file;
    }

    public void setFile(File file) {
	this.file = file;
    }

    public List<String> readLines() {
	List<String> lines = new LinkedList<>();
	try (BufferedReader bw = new BufferedReader(new FileReader(file))) {
	    String line;
	    while ((line = bw.readLine()) != null) {
		lines.add(line);
	    }
	} catch (IOException ex) {
	    throw new IllegalStateException(ex);
	}
	return lines;
    }
}
