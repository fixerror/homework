package com.sourceit.radchenko.hw7.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.sourceit.radchenko.hw7.ITaskExecutor;
import com.sourceit.radchenko.hw7.ITasksStorage;
import com.sourceit.radchenko.hw7.impl.CopyFileTaskImpl;
import com.sourceit.radchenko.hw7.impl.FindFilesTaskImpl;
import com.sourceit.radchenko.hw7.impl.NamePrinterImpl;
import com.sourceit.radchenko.hw7.impl.TaskExecutorImpl;
import com.sourceit.radchenko.hw7.impl.TaskStrogeImpl;

public class Main {

	public static void main(String[] args) {

		String pathname = "test\\test0.txt";

		PrintStream printStream = null;
		try {
			printStream = new PrintStream(new FileOutputStream(new File(
					pathname)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// - RUN -----------------------------------------------------------

		NamePrinterImpl npr = new NamePrinterImpl();
		npr.setCount(4);
		npr.setInterval(1000);
		npr.setPrintName("Source IT");
		npr.setStream(printStream);

		Thread thread1 = new Thread(npr);

		thread1.start();

		// EXECUTOR ------------------------------------------------------
		
		String directory="C:\\Users\\Sanja\\workspace\\hw6";
		String searchString="java";

		FindFilesTaskImpl ffs =	new FindFilesTaskImpl(directory, searchString);
		ITasksStorage ts = new TaskStrogeImpl();

		ts.add(new CopyFileTaskImpl("test\\test1.txt", "test\\testS1.txt"));
		ts.add(new CopyFileTaskImpl("test\\test2.txt", "test\\testS2.txt"));
		ts.add(new CopyFileTaskImpl("test\\test3.txt", "test\\testS3.txt"));

		ts.add(ffs);
		//ts.add(new FindFilesTaskImpl());
		//ts.add(new FindFilesTaskImpl());
		//ts.add(new FindFilesTaskImpl());
		//ts.add(new FindFilesTaskImpl());

		ITaskExecutor executor1 = new TaskExecutorImpl();
		executor1.setStorage(ts);
		executor1.start();

		ITaskExecutor executor2 = new TaskExecutorImpl();
		executor2.setStorage(ts);
		executor2.start();
		
		ITaskExecutor executor3 = new TaskExecutorImpl();
		executor3.setStorage(ts);
		executor3.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		executor1.stop();
		executor2.stop();
		executor3.stop();

		System.out.println("end");

	}

}
