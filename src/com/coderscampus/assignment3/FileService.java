package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
	public User[] readFile(String filename) {
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(filename));
			String line;
			User[] userArray = new User[4];
			int count = 0;

			while ((line = fileReader.readLine()) != null) {
				String[] userSplit = line.split(",");
				User user = new User(userSplit[0], userSplit[1], userSplit[2]);
				userArray[count] = user;
				count++;
			}
			return userArray;
		} catch (FileNotFoundException e) {
			System.out.println("The file wasn't found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("There was an I/O Exception");
			e.printStackTrace();
		}
		return null;
	}
}
