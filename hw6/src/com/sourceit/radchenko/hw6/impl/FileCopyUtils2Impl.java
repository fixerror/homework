package com.sourceit.radchenko.hw6.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sourceit.radchenko.hw6.IFileCopyUtils;
import com.sourceit.radchenko.hw6.exception.FileAlreadyExistsException;
import com.sourceit.radchenko.hw6.exception.FileCopyFailedException;

public class FileCopyUtils2Impl implements IFileCopyUtils {

	@Override
	public void copyFile(String source, String destination)
			throws FileCopyFailedException, FileAlreadyExistsException {
		File from_file = new File(source);
		File to_file = new File(destination);
		if (to_file.exists()) {
			throw new FileAlreadyExistsException("File already exists: "
					+ destination);
		}
		FileInputStream from = null;
		FileOutputStream to = null;
		try {
			from = new FileInputStream(from_file);
			to = new FileOutputStream(to_file);
			BufferedInputStream bis = new BufferedInputStream(from);
			BufferedOutputStream bos = new BufferedOutputStream(to);

			int c = 0;
			while (true) {
				c = bis.read();
				if (c != -1)
					bos.write(c);
				else
					break;
			}
			bis.close();
			bos.flush();
			bos.close();
			System.out
					.println("The method createBufferedFileCopyUtils() is complete");
		} catch (IOException e) {
			System.out.println(e.toString());
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
