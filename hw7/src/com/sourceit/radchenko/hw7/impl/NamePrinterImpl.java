package com.sourceit.radchenko.hw7.impl;

import java.io.PrintStream;

import com.sourceit.radchenko.hw7.INamePrinter;

public class NamePrinterImpl implements INamePrinter, Runnable {
	private String name;
	private PrintStream stream;
	private long interval = 0;
	private int count = 0;

	@Override
	public void setPrintName(String name) throws NullPointerException,
			IllegalArgumentException {
		if (name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if (name.length() == 0) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}

	@Override
	public void setStream(PrintStream stream) throws NullPointerException {
		if (stream == null) {
			throw new NullPointerException();
		}
		this.stream = stream;
	}

	@Override
	public void setInterval(long ms) throws IllegalArgumentException {
		if (ms <= 0) {
			throw new IllegalArgumentException();
		}
		interval = ms;
	}

	@Override
	public void setCount(int count) throws IllegalArgumentException {
		if (count <= 0) {
			throw new IllegalArgumentException();
		}
		this.count = count;

	}

	@Override
	public void run() {
		synchronized (stream) {
			for (int i = count; i != 0; i--) {
				stream.print(name);
				try {
					Thread.sleep(interval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
