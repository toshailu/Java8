/**
 * 
 */
package com.shailu.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Shailu
 *
 */
public class ReadFileLineByLineDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String fName = "C:/Users/Shailu/Desktop/filereading.txt";

		readAllLineAsStream(fName);

		filterFileData(fName);

		readingUsingBufferedReader(fName);
	}

	/**
	 * @param fName
	 */
	private static void readingUsingBufferedReader(String fName) {

		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(fName));
			Stream<String> lines = br.lines().map(str -> str.toUpperCase());
			System.out.println(" ********* Reading using Buffered Reader ************");
			lines.forEach(System.out::println);
			lines.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param fName
	 */
	private static void filterFileData(String fName) {

		try {
			Stream<String> lines = Files.lines(Paths.get(fName));
			System.out.println("******** Reading files with Filter");
			lines.filter(line -> line.startsWith("S")).forEach(System.out::println);
			lines.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param fName
	 */
	private static void readAllLineAsStream(String fName) {

		try {

			Stream<String> lines = Files.lines(Paths.get(fName));
			System.out.println("..........Reading All Lines as a Stream.............");
			lines.forEach(System.out::println);
			lines.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
