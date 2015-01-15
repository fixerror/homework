package com.sourceit.radchenko.hw6.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.sourceit.radchenko.hw6.IFileCopyUtils;
import com.sourceit.radchenko.hw6.exception.FileAlreadyExistsException;
import com.sourceit.radchenko.hw6.exception.FileCopyFailedException;

public class FileCopyUtils3Impl implements IFileCopyUtils {
	private static final int BSIZE = 1024;

	@Override
	public void copyFile(String source, String destination)
			throws FileCopyFailedException, FileAlreadyExistsException {
		File to_file = new File(destination);
		if (to_file.exists()) {
			throw new FileAlreadyExistsException("File already exists: "
					+ destination);
		}
		try {

			FileInputStream fileInputStream = new FileInputStream(source);
			FileChannel in = fileInputStream.getChannel();
			FileOutputStream fileOutputStream = new FileOutputStream(
					destination);
			FileChannel out = fileOutputStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
			while (in.read(buffer) != -1) {
				buffer.flip();
				out.write(buffer);
				buffer.clear();
			}
			fileInputStream.close();
			fileOutputStream.close();
			System.out
					.println("The method createChannelsFileCopyUtils() is complete");
		} catch (IOException e) {
			System.out.println(e.toString());

		}

	}
}
