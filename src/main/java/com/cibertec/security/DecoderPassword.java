package com.cibertec.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DecoderPassword {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String password = "miguel2003";
		String encodedPassword = "$2a$10$Y5NT0eLsqsBYZYj6GEYmZeu8dlcwpJodlJHCJIrErbwLqBFCrh1Mm";
		
		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
		
	}
}
