package com.coderscampus.assignment3;

public class UserService {
	private User[] userArray;

	public void generateUser(String filename) {
		FileService fileService = new FileService();
		userArray = fileService.readFile(filename);
	}

	public User validateUser(String username, String password) {

		for (User user : userArray) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user;
			}
		}

		return null;
	}
}
