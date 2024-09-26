package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLoginApp {

	public static void main(String[] args) {
		UserService userService = new UserService();
		userService.generateUser("src/data.txt");
		Scanner scanner = new Scanner(System.in);
		String username;
		String password;
		int maxAttempts = 5;

		for (int i = 0; i < maxAttempts; i++) {
			System.out.println("Enter your email: ");
			username = scanner.nextLine();
			System.out.println("Enter your password: ");
			password = scanner.nextLine();

			User valUser = userService.validateUser(username, password);
			if (valUser != null) {
				System.out.println("Welcome " + valUser.getName());
				break;
			} else if (i == maxAttempts - 1) {
				System.out.println("Too many failed login attempts, you are now locked out1");
			} else {
				System.out.println("Invlid login, please try again");
			}
		}
		scanner.close();
	}
}
