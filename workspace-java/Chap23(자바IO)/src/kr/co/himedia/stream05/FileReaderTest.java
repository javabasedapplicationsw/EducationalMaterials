package kr.co.himedia.stream05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try(FileReader fr = new FileReader("reader.txt")) {
			int i;
			while( (i = fr.read()) != -1 )
				System.out.print((char)i);
		}
	}
}
