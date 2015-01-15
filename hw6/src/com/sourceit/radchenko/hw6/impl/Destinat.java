package com.sourceit.radchenko.hw6.impl;

import java.io.File;

public class Destinat {

	private String destination;
	private String destination1;

	public void setDestination(String destination) {
		this.destination = destination;
	}

	// Function to check FileCopyTestUtilsImplementation
	public String dest() {
		if ((new File(destination)).exists()) {
			String destinationS = "C:\\Users\\Sanja\\workspace\\hw6\\src\\com\\sourceit\\radchenko\\hw6\\";
			int destinationF = 0;
			do {
				destinationF++;
				destination1 = destinationS + destinationF + ".txt";
			} while ((new File(destination)).exists() == (new File(destination1))
					.exists());
			return destination1;
		} else {
			destination1 = destination;
		}
		return destination1;
	}
}
