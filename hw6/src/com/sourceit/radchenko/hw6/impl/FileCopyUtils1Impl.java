package com.sourceit.radchenko.hw6.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sourceit.radchenko.hw6.IFileCopyUtils;
import com.sourceit.radchenko.hw6.exception.FileAlreadyExistsException;
import com.sourceit.radchenko.hw6.exception.FileCopyFailedException;

public class FileCopyUtils1Impl implements IFileCopyUtils {

	public void copyFile(String source, String destination)
			throws FileCopyFailedException, FileAlreadyExistsException {
		File from_file = new File(source);
		File to_file = new File(destination);
		if (to_file.exists()) {
			throw new FileAlreadyExistsException("File already exists:"
					+ destination);
		}
		FileInputStream from = null;
		FileOutputStream to = null;
		try {
			from = new FileInputStream(from_file);
			to = new FileOutputStream(to_file);

			while (from.available() > 0) {
				int S1 = from.read();
				to.write(S1);
			}
			from.close();
			to.close();
			System.out
					.println("The method createSimpleFileCopyUtils() is complete");
		} catch (IOException e) {
			if (from != null) {
				try {
					from.close();
				} catch (IOException e1) {
					throw new FileCopyFailedException("flow :  " + source
							+ "  not closed");
				}
				if (to != null) {
					try {
						to.close();
					} catch (IOException e2) {
						throw new FileCopyFailedException("flow :  "
								+ destination + "  not closed");
					}

				}
			}

		}

	}

}
