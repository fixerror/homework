package com.sourceit.radchenko.hw6.test;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.sourceit.radchenko.hw6.IFileCopyUtils;
import com.sourceit.radchenko.hw6.IOUtils;
import com.sourceit.radchenko.hw6.exception.FileAlreadyExistsException;
import com.sourceit.radchenko.hw6.exception.FileCopyFailedException;
import com.sourceit.radchenko.hw6.impl.Destinat;
import com.sourceit.radchenko.hw6.impl.FileCopyTestUtilsImpl;
import com.sourceit.radchenko.hw6.impl.IOUtilsImpl;

public class Main {

	public static void main(String[] args) throws FileAlreadyExistsException,
			FileCopyFailedException {
		/* ===============replaceChars============================ */
		System.out
				.println("replaceChars -Copy a string from the input stream to the output, simultaneously replacing symbols:");
		IOUtils iou = new IOUtilsImpl();

		char[] ca = { 'r', 'a', 'd', 'c', 'h', 'e', 'n', 'k', 'o' };
		Reader r = new CharArrayReader(ca);

		Writer w = new CharArrayWriter();

		iou.replaceChars(r, w, "rch", "RCH");

		System.out.println(w);
		/* ==============findFiles================================ */
		System.out
				.println("findFiles -The function finds all files in a directory and subdirectories and returns the full path in the form of an array of strings:");
		String fileName = "C:\\Users\\Sanja\\workspace\\hw6";

		String[] files = iou.findFiles(fileName);

		for (String string : files) {
			System.out.println("file:   " + string);
		}
		/* ==============copy files=============================== */
		String source = "C:\\Users\\Sanja\\workspace\\hw6\\src\\com\\sourceit\\radchenko\\hw6\\1.txt";
		String destination = "C:\\Users\\Sanja\\workspace\\hw6\\src\\com\\sourceit\\radchenko\\hw6\\2.txt";
		Destinat des = new Destinat();
		des.setDestination(destination);
		FileCopyTestUtilsImpl copyTestUtils = new FileCopyTestUtilsImpl();
		// FileCopyUtils1Implementation
		IFileCopyUtils copyF1 = copyTestUtils.createSimpleFileCopyUtils();
		try {
			// Function to get around FileAlreadyExistsException
			String destination1 = des.dest();
			// copy using FileInputStream
			copyF1.copyFile(source, destination1);
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
		} catch (FileCopyFailedException e) {
			e.printStackTrace();
		}
		// FileCopyUtils2Implementation
		IFileCopyUtils copyF2 = copyTestUtils.createBufferedFileCopyUtils();
		try {
			// Function to get around FileAlreadyExistsException
			String destination2 = des.dest();
			// Copy using buffered streams
			copyF2.copyFile(source, destination2);
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
		} catch (FileCopyFailedException e) {
			e.printStackTrace();
		}
		// FileCopyUtils3Implementation
		IFileCopyUtils copyF3 = copyTestUtils.createChannelsFileCopyUtils();
		try {
			// Function to get around FileAlreadyExistsException
			String destination3 = des.dest();
			// Copy using channels
			copyF3.copyFile(source, destination3);
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
		} catch (FileCopyFailedException e) {
			e.printStackTrace();
		}
		// FileCopyUtils4Implementation
		IFileCopyUtils copyF4 = copyTestUtils.createJava7CopyUtils();
		try {
			// Function to get around FileAlreadyExistsException
			String destination4 = des.dest();
			// Copy using the power of Java 7
			copyF4.copyFile(source, destination4);
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
		} catch (FileCopyFailedException e) {
			e.printStackTrace();
		}

		// Creating a 1GB file
		System.out.println("Creating a 1GB file ");
		long time1 = System.currentTimeMillis();
		File file = new File("data.txt");
		if (!(file.exists())) {
			FileChannel fc = null;
			try {
				fc = new FileOutputStream("data.txt").getChannel();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				while (fc.size() != 1024 * 1024 * 1024) {
					fc.write(ByteBuffer.wrap("0".getBytes()));
					if (fc.size() > 1024 * 1024 * 1024) {
						break;
					}
				}
				fc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			long time2 = System.currentTimeMillis();
			System.out.println(time1 - time2 + "(millis) Creating a 1GB file");
		}
		System.out.println("File is created ");
		System.out.println("Start Copying ");
		String source1gb = "C:\\Users\\Sanja\\workspace\\hw6\\data.txt";
		String destination1gb = "C:\\Users\\Sanja\\workspace\\hw6\\data2.txt";
		long time3 = System.currentTimeMillis();
		try {
			// Copy using the power of Java 7
			copyF4.copyFile(source1gb, destination1gb);
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
		} catch (FileCopyFailedException e) {
			e.printStackTrace();
		}
		long time4 = System.currentTimeMillis();
		System.out.println("Stop Copying ");
		System.out.println(time4 - time3 + "(millis) copy time");
	}
}
