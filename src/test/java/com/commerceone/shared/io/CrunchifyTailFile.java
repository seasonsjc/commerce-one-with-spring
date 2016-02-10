package com.commerceone.shared.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.stream.Stream;

public class CrunchifyTailFile {

	public static void main(String[] args) throws IOException {

		long fileSize = 0L;

		File file = new File("C:\\Users\\Bisso\\Desktop\\log1.log");

		fileSize = file.length();
		//
		// RandomAccessFile raf = new RandomAccessFile(file, "r");
		//
		// String line = null;
		// int i = 0;
		// int skip = 3000;
		// while ((line = raf.readLine()) != null) {
		// System.out.println("Line [" + i + "] Pointer " +
		// raf.getFilePointer());
		// if (i >= skip) {
		// System.out.println(line);
		// }
		// i++;
		// }

		
//		try (Stream<String> lines = Files.lines(file.toPath())) {
//			
//			//System.out.println("Total Lines " + lines.count());
//			
//			lines.skip(24000)
//				 .forEach(item->System.out.println(item));
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		
		 LineNumberReader reader  = new LineNumberReader(new FileReader(file));
		 String lineRead = null;
		 reader.
		 reader.skip(1000000l);
		 while ((lineRead = reader.readLine()) != null) {
			 System.out.println(lineRead);
		 }
		 
		 
		
		
	}

}
