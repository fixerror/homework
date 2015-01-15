package com.sourceit.radchenko.hw6.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import com.sourceit.radchenko.hw6.IFileCopyUtils;
import com.sourceit.radchenko.hw6.exception.FileAlreadyExistsException;
import com.sourceit.radchenko.hw6.exception.FileCopyFailedException;

public class FileCopyUtils4Impl implements IFileCopyUtils {

	@Override
	public void copyFile(String source, String destination)
			throws FileCopyFailedException, FileAlreadyExistsException {
		File from_file = new File(source);
		File to_file = new File(destination);
		if (to_file.exists()) {
			throw new FileAlreadyExistsException("File already exists: "
					+ destination);
		}
		if (!to_file.exists()) {
			try {
				to_file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (FileChannel in1 = new FileInputStream(from_file).getChannel();
				FileChannel out2 = new FileOutputStream(to_file).getChannel()) {
			out2.transferFrom(in1, 0, in1.size());
			System.out.println("The method createJava7CopyUtils() is complete");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * Or the shortest record Files.copy( from.toPath(), to.toPath() );
		 */
	}

}
