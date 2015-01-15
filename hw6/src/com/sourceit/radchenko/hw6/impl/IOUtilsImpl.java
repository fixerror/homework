package com.sourceit.radchenko.hw6.impl;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.sourceit.radchenko.hw6.IOUtils;

public class IOUtilsImpl implements IOUtils {

	@Override
	public void replaceChars(Reader in, Writer out, String inChars,
			String outChars) throws NullPointerException,
			IllegalArgumentException {

		if ((in == null) || (out == null)) {
			throw new NullPointerException();
		}
		if (inChars != null && outChars != null
				&& inChars.length() != outChars.length()) {
			throw new IllegalArgumentException();
		}
		int n = 0;
		if (inChars == null || outChars == null) {
			n = 0;
		} else {
			n = inChars.length();
		}
		Map<Character, Character> map = new HashMap<Character, Character>(n);
		for (int i = 0; i < n; i++) {
			map.put(inChars.charAt(i), outChars.charAt(i));
		}

		int c = 0;
		char ch = 0;

		try {
			while ((c = in.read()) != -1) {
				ch = (char) c;
				if (map.containsKey(ch)) {
					ch = map.get(ch);
				}
				out.write(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String[] findFiles(String dir) throws NullPointerException,
			IllegalArgumentException {
		File dirS1 = new File(dir);
		if (!dirS1.exists()) {
			throw new IllegalArgumentException();
		}

		List<String> foundFiles = new ArrayList<String>();
		Queue<File> dirS2 = new LinkedList<File>();

		dirS2.add(dirS1);

		while (!dirS2.isEmpty()) {
			File currentFolder = dirS2.remove();
			File[] currentFiles = currentFolder.listFiles();

			for (File f : currentFiles) {
				if (f.isDirectory()) {
					dirS2.add(f);
				} else if (f.isFile()) {
					foundFiles.add(f.getAbsolutePath());
				} else {
					throw new RuntimeException("It isn't file or folder");
				}
			}
		}

		return foundFiles.toArray(new String[foundFiles.size()]);
	}

}
