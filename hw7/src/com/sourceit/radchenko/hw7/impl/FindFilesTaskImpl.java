package com.sourceit.radchenko.hw7.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sourceit.radchenko.hw7.IFindFilesTask;
import com.sourceit.radchenko.hw7.exception.TaskExecutionFailedException;

public class FindFilesTaskImpl implements IFindFilesTask {
	private int tryCount;
	private String directory;
	private String searchString;
	private PrintStream out;
	private File dir;
	private FileChannel fChannel = null;
	private File files;

	public FindFilesTaskImpl(String directory, String searchString) {
		this.directory = directory;
		this.searchString = searchString;
	}

	public String getDirectory() {
		return directory;
	}

	public String getSearchString() {
		return searchString;
	}

	@Override
	public int getTryCount() {
		return tryCount;
	}

	@Override
	public void incTryCount() {
		tryCount++;

	}

	@Override
	public boolean execute() throws TaskExecutionFailedException, Exception {
		File dir = new File(getDirectory());
		List<String> foundFiles = new ArrayList<String>();
		Queue<File> dirS1 = new LinkedList<File>();
		if (!dir.exists()) {
			throw new IllegalArgumentException();
		}
		dirS1.add(dir);

		while (!dirS1.isEmpty()) {
			File currentFolder = dirS1.remove();
			File[] currentFiles = currentFolder.listFiles(new FileFilter() {
				public boolean accept(File file) {
					String f = file.getName();
					return f.indexOf(getSearchString()) != -1;
				}
			});
			for (File f : currentFiles) {
				if (f.isDirectory()) {
					dirS1.add(f);
				} else if (f.isFile()) {
					foundFiles.add(f.getAbsolutePath());
				} else {
					throw new RuntimeException("It isn't file or folder");
				}
			}
		}

		files = new File("dataF.txt");

		fChannel = new FileOutputStream("dataF.txt").getChannel();
		String[] filesSS = foundFiles.toArray(new String[foundFiles.size()]);
		for (String string : filesSS) {
			fChannel.write(ByteBuffer.wrap(string.getBytes()));
			fChannel.close();
		}

		boolean performed = true;
		if (!performed) {
			throw new TaskExecutionFailedException(
					"Task was not completed correctly");
		}
		return performed;
	}

	@Override
	public void setDirectory(String directory) throws NullPointerException,
			FileNotFoundException {
		if (directory == null) {
			throw new NullPointerException();
		}
		this.directory = directory;
		if (!dir.isDirectory()) {
			throw new FileNotFoundException("Directory does not exist");
		}

	}

	@Override
	public void setFileNameSearchString(String searchString)
			throws IllegalArgumentException {
		if (searchString == null) {
			throw new IllegalArgumentException();
		}
		this.searchString = searchString;
	}

	@Override
	public void setPrintStream(PrintStream out) {
		this.out = out;
	}

}
