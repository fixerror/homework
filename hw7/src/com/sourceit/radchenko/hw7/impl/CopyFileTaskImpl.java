package com.sourceit.radchenko.hw7.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import com.sourceit.radchenko.hw6.IFileCopyUtils;
import com.sourceit.radchenko.hw7.ICopyFileTask;
import com.sourceit.radchenko.hw7.exception.TaskExecutionFailedException;

public class CopyFileTaskImpl implements ICopyFileTask {

	private int tryCount;
	private String destinatio;
	private String source;

	public CopyFileTaskImpl() {
	}

	public CopyFileTaskImpl(String source, String destinatio) {

		this.source = source;
		this.destinatio = destinatio;

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
	public boolean execute() throws Exception {

		// FileCopyUtils4Implementation ioUtils =new
		// FileCopyUtils4Implementation();
		//
		// try {
		// ioUtils.copyFile(source, destinatio);
		// } catch (Exception e) {
		// return false;
		// }

		FileInputStream input = null;
		try {
			input = new FileInputStream(source);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		}

		FileOutputStream output = null;

		try {
			output = new FileOutputStream(destinatio);
		} catch (FileNotFoundException e) {
			File fileDest = new File(destinatio);
			try {
				fileDest.createNewFile();
			} catch (IOException e1) {
				throw new IllegalArgumentException(e1);
			} finally {
				try {
					input.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		FileChannel inputChannel = input.getChannel();
		FileChannel ouptupChannel = output.getChannel();

		try {
			inputChannel.transferTo(0, inputChannel.size(), ouptupChannel);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean performed = true;
		if (!performed) {
			throw new TaskExecutionFailedException(
					"Task was not completed correctly");
		}
		return performed;

	}

	@Override
	public void setFileCopyUtils(IFileCopyUtils copyUtils) {

		/*
		 * FileCopyUtils4Implementation ioUtils =new
		 * FileCopyUtils4Implementation(); try { ioUtils.copyFile(source,
		 * destinatio); } catch (FileAlreadyExistsException e) {
		 * e.printStackTrace(); } catch (FileCopyFailedException e) {
		 * e.printStackTrace(); } finally { }
		 */

	}

}