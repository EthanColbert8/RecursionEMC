package edu.bellarmine.emc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class writes the results of each calculation to the file.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 3
 * Fall 2019
 */

public class TextWriter {
	
	private FileWriter writer;//lets us write to the file
	private File records;//a File object representing the file we're writing to
	
	/**
	 * Empty-argument constructor.
	 */
	public TextWriter() {
		
	}// end empty-argument constructor
	
	/**
	 * Full-argument constructor - allows you to write to the specified file.
	 * @param fileName - the name of the file to write to
	 */
	public TextWriter(String fileName) {
		
		this.setRecords(fileName);
		
	}// end full-argument constructor
	
	/**
	 * This method writes the next line in the record.
	 * @param nextLine - the line to write to the file
	 */
	public void writeRecord(String nextLine) {
		
		try {
			
			writer = new FileWriter(records, true);
			writer.append(nextLine + "\n");
			writer.close();
		
		}
		catch(IOException e) {
			System.out.println("Failed to write records to file.\nFile may be corrupted.");
		}
		
	}// end "writeScores" method
	
	/**
	 * @return the name of the file this writer writes to.
	 */
	public String getRecords() {
		return records.toString();
	}

	/**
	 * @param records - the name of the file we want to write to.
	 */
	public void setRecords(String fileName) {
		records = new File(fileName);
	}

	@Override
	public String toString() {
		return "TextWriter [records = " + records.toString() + "]";
	}
	
}// end "TextWriter" class
