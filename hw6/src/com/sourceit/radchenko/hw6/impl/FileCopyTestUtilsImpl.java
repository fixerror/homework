package com.sourceit.radchenko.hw6.impl;

import com.sourceit.radchenko.hw6.IFileCopyUtils;

public class FileCopyTestUtilsImpl {

	public IFileCopyUtils createSimpleFileCopyUtils() {

		return new FileCopyUtils1Impl();
	}

	public IFileCopyUtils createBufferedFileCopyUtils() {

		return new FileCopyUtils2Impl();
	}

	public IFileCopyUtils createChannelsFileCopyUtils() {

		return new FileCopyUtils3Impl();
	}

	public IFileCopyUtils createJava7CopyUtils() {

		return new FileCopyUtils4Impl();
	}

}
